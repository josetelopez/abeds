package com.peretecorporate.abedsbackend.configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;

import com.peretecorporate.abedsbackend.enumerados.ETipoError;
import com.peretecorporate.abedsbackend.error.ErrorDto;
import com.peretecorporate.abedsbackend.exception.AbedsBackendException;
import com.peretecorporate.abedsbackend.exception.AbedsBackendNoTransactionalException;

@RestControllerAdvice
public class AbedsExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(AbedsExceptionHandler.class);

	@GetMapping(produces = {"application/json"})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({AbedsBackendException.class})
	public final ErrorDto handleBeanAbedsExceptionHandler(AbedsBackendException exp) {
		log.error(exp.getMessage());
		ErrorDto errorDetails = new ErrorDto();
		errorDetails.setMessage(exp.getMessage());
		errorDetails.setErrors(exp.getErrors());
		errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return errorDetails;
	}

	@GetMapping(produces = {"application/json"})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({AbedsBackendNoTransactionalException.class})
	public final ErrorDto handleBeanAbedsExceptionHandler(AbedsBackendNoTransactionalException exp) {
		log.error(exp.getMessage());
		ErrorDto errorDetails = new ErrorDto();
		errorDetails.setMessage(exp.getMessage());
		errorDetails.setErrors(exp.getErrors());
		errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return errorDetails;
	}

	@GetMapping(produces = {"application/json"})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({AccessDeniedException.class})
	public final ErrorDto handleBeanAbedsAccessDeniedExceptionHandler(AccessDeniedException exp) {
		log.error(exp.getMessage());
		ErrorDto errorDetails = new ErrorDto();
		errorDetails.setMessage("No está autorizado a realizar la operación");
		errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return errorDetails;
	}

	@GetMapping(produces = {"application/json"})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({SecurityException.class})
	public final ErrorDto handleBeanAbedsSecurityExceptionHandler(SecurityException exp) {
		log.error(exp.getMessage());
		ErrorDto errorDetails = new ErrorDto();
		errorDetails.setMessage("No está autorizado a realizar la operación");
		errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return errorDetails;
	}

	@GetMapping(produces = {"application/json"})
	@ExceptionHandler({RuntimeException.class})
	public final ResponseEntity<ErrorDto> handleException(RuntimeException exp) {
		log.error(exp.getMessage());

		ErrorDto errorDetails = new ErrorDto();
		errorDetails.setMessage("Ha ocurrido un error");
		errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

		HttpStatus myhttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		if (exp instanceof DataIntegrityViolationException || exp instanceof ConstraintViolationException) {
			errorDetails = handleBeanRollbackException(new RollbackException(exp));
			myhttpStatus = HttpStatus.FORBIDDEN;
		}
		else if (exp instanceof org.springframework.transaction.TransactionSystemException) {

			errorDetails = handleBeanRollbackException(new RollbackException(exp.getCause().getCause()));
			myhttpStatus = HttpStatus.FORBIDDEN;
		}
		else if (exp.getCause() != null && exp.getCause().getCause() != null
					&& exp.getCause().getCause().getMessage() != null) {
			errorDetails.setMessage("Error debido a configuración de los analisis técnicos en el departamento.");
			myhttpStatus = HttpStatus.FORBIDDEN;
		}
		else if (exp instanceof BadCredentialsException) {
			errorDetails = handleBeanRollbackException(new RollbackException(exp));
			myhttpStatus = HttpStatus.FORBIDDEN;
		}
		else {

			log.error("Ha ocurrido un error", exp);
			errorDetails.setMessage(exp.getMessage());
			errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		}

		return new ResponseEntity(errorDetails, myhttpStatus);
	}

	@GetMapping(produces = {"application/json"})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({RollbackException.class})
	public final ErrorDto handleBeanRollbackException(RollbackException exp) {
		ErrorDto errorDetails;
		log.error(exp.getMessage());

		if (exp.getCause() instanceof ConstraintViolationException
					|| exp.getCause().getCause() instanceof ConstraintViolationException) {
			errorDetails = formatearConstraintViolationException((ConstraintViolationException) exp.getCause());
		}
		else {

			errorDetails = formatearDataIntegrityViolationException((DataIntegrityViolationException) exp.getCause());
		}
		errorDetails.setTimestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return errorDetails;
	}

	private final ErrorDto formatearDataIntegrityViolationException(DataIntegrityViolationException ex) {
		log.error("DataIntegrityViolationException NO implementada");
		log.error(ex.getClass().getCanonicalName());
		log.error(ex.getLocalizedMessage());
		ErrorDto errorDetails = new ErrorDto();
		errorDetails.setMessage(ex.getMessage());
		return errorDetails;
	}

	private final ErrorDto formatearConstraintViolationException(ConstraintViolationException ex) {
		log.warn("Error de validacion de campos");
		ErrorDto errorDetails = new ErrorDto();
		StringBuilder sb = new StringBuilder();
		sb.append("Se").append((ex.getConstraintViolations().size() == 1) ? " ha " : " han ").append(" localizado ")
					.append(ex.getConstraintViolations().size())
					.append((ex.getConstraintViolations().size() == 1) ? " error " : " errores ")
					.append("de validación de datos.");
		List<String> detalles = new LinkedList<>();
		log.warn(sb.toString());
		for (ConstraintViolation<?> ob : (Iterable<ConstraintViolation<?>>) ex.getConstraintViolations()) {
			StringBuilder sbN = new StringBuilder();
			sbN.append(capitalizeStringName(ob.getPropertyPath().toString()));
			reflexNombreDescriptivo(ob, sbN);
			detalles.add("El campo " + sbN.toString() + " " + ob.getMessage());
		}
		errorDetails.setErrors(detalles);
		errorDetails.setMessage(sb.toString());
		errorDetails.setTipo(ETipoError.VALIDATION);
		return errorDetails;
	}

	/**
	 * Revisar
	 * @param ob
	 * @param sbN
	 */
	private void reflexNombreDescriptivo(ConstraintViolation<?> ob, StringBuilder sbN) {
		Arrays.asList(ob.getLeafBean().getClass().getDeclaredFields()).parallelStream()
					.filter(a -> a.getName().equals(ob.getPropertyPath().toString()))
					.forEach(x -> Arrays.asList(x.getAnnotations()));
	}

	private String capitalizeStringName(String string) {
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < string.length(); k++) {
			if (Character.isUpperCase(string.charAt(k)) && k > 0) {
				sb.append(" ");
			}
			if (Character.isUpperCase(string.charAt(k)) || k == 0) {
				sb.append(Character.toUpperCase(string.charAt(k)));
			}
			else {

				sb.append(string.charAt(k));
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("nombre de la propiedad sanetizado:" + sb.toString());
		}
		return sb.toString();
	}
}
