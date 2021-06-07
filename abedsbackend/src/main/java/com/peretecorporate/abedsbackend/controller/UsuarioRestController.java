package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.exception.AbedsBackendException;
import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuario")
@Api(value = "/usuario", tags = {"Operaciones con usuarios"})
public class UsuarioRestController {

	private static final Logger	log	= LoggerFactory.getLogger(UsuarioRestController.class);

	/** Servicio usuario */
	@Autowired
	private UsuarioService		usuarioService;
	

	@RequestMapping(value = "/allUsuario", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener listado usuarios", notes = "Este metodo obtiene un listado de todos los usuarios")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<List<Usuario>> findAll() throws AbedsBackendException {
		log.info("REST Solicitud GET de /usuario/allUsuario para obtener listado de usuarios.");

		List<Usuario> usuarioList = usuarioService.findAll();

		if (!usuarioList.isEmpty()) {
			log.info("REST Respuesta GET de /usuario/allUsuario  para obtener listado de usuarios. " + HttpStatus.OK);
			return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/allUsuario  para obtener listado de usuarios. "
					+ HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/findUsuarioByid/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener usuario", notes = "Este metodo obtiene un usuario por su id")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<Usuario> findUsuarioByid(
				@ApiParam(value = "id de usuario del usuario que vamos a buscar", required = true) @PathVariable("id") Integer id) throws AbedsBackendException {
		log.info("REST Solicitud GET de /usuario/findUsuarioByid/{id} para obtener usuario por id " + id);

		Usuario usuario = usuarioService.findUsuarioByidUsuario(id);
		if (usuario != null) {
			log.info("REST Respuesta GET de /usuario/findUsuarioByid/{id}  para obtener usuario por id . " + id + " "
						+ HttpStatus.OK);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/findUsuarioByid/{id}  para obtener usuario por id . " + id + " "
					+ HttpStatus.NO_CONTENT);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/findUsuarioByNombre/{nombre}/{apellido1}/{apellido2}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener usuario por nombre - apellido1 - apellido2", notes = "Este metodo obtiene un usuario por su nombre completo")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<Usuario> findUsuarioByNombre(
				@ApiParam(value = "nombre del usuario que vamos a buscar", required = true) @PathVariable("nombre") String nombre,
				@ApiParam(value = "apellido1 de usuario del usuario que vamos a buscar", required = true) @PathVariable("apellido1") String apellido1,
				@ApiParam(value = "apellido2 de usuario del usuario que vamos a buscar", required = true) @PathVariable("apellido2") String apellido2) throws AbedsBackendException {

		log.info("REST Solicitud GET de /usuario/findUsuarioByNombre/{nombre}/{apellido1}/{apellido2} para obtener usuario por nombre,apellido1,apellido2 "
					+ nombre + " " + apellido1 + " " + apellido2 + " " + HttpStatus.NO_CONTENT);

		Usuario usuario = usuarioService.findUsuarioByNombre(nombre, apellido1, apellido2);
		if (usuario != null) {
			log.info("REST Respuesta GET de /usuario/findUsuarioByNombre/{nombre}/{apellido1}/{apellido2} para obtener usuario por nombre,apellido1,apellido2"
						+ nombre + " " + apellido1 + " " + apellido2 + " " + HttpStatus.NO_CONTENT);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/findUsuarioByNombre/{nombre}/{apellido1}/{apellido2} para obtener usuario por nombre,apellido1,apellido2"
					+ nombre + " " + apellido1 + " " + apellido2);

		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/findUsuarioBynif/{nif}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener usuario por dni", notes = "Este metodo obtiene un usuario por su dni")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<Usuario> findUsuarioBynif(
				@ApiParam(value = "nif del usuario que vamos a buscar", required = true) @PathVariable("nif") String nif) throws AbedsBackendException {

		log.info("REST Solicitud GET de /usuario/findUsuarioBynif/{nif} para obtener un usuario por nif " + nif);

		Usuario usuario = usuarioService.findUsuarioBynif(nif);
		if (usuario != null) {
			log.info("REST Respuesta GET de /usuario/findUsuarioBynif/{nif} para obtener usuario por dni" + nif + " "
						+ HttpStatus.OK);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/findUsuarioBynif/{nif} para obtener usuario por dni" + nif + " "
					+ HttpStatus.NO_CONTENT);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/findUsuarioByemail/{email}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener usuario por email", notes = "Este metodo obtiene un usuario por su email")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<Usuario> findUsuarioByemail(
				@ApiParam(value = "email del usuario que vamos a buscar", required = true) @PathVariable("email") String email) throws AbedsBackendException {

		log.info("REST Solicitud GET de /usuario/findUsuarioByemail/{email} para obtener un usuario por email "
					+ email);

		Usuario usuario = usuarioService.findUsuarioByemail(email);
		if (usuario != null) {
			log.info("REST Respuesta GET de /usuario/findUsuarioByemail/{email} para obtener usuario por email" + email
						+ " " + HttpStatus.NO_CONTENT);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/findUsuarioByemail/{email} para obtener usuario por email" + email
					+ " " + HttpStatus.NO_CONTENT);

		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/allAdministradores", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener listado de usuarios por tipo de usuario administrador", notes = "Este metodo obtiene un listado de todos usuarios administradores")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<List<Usuario>> getListadoUsuariosAdministradores() throws AbedsBackendException {

		log.info("REST Solicitud GET de /usuario/allAdministradores para obtener un listado de todos los usuarios administradores");

		List<Usuario> userAdmList = usuarioService.getListadoUsuariosAdministradores();
		if (userAdmList != null && !userAdmList.isEmpty()) {
			log.info("REST Respuesta GET de  /usuario/allAdministradores para obtener un listado de todos los usuarios administradores"
						+ HttpStatus.OK);
			return new ResponseEntity<List<Usuario>>(userAdmList, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de  /usuario/allAdministradores para obtener un listado de todos los usuarios administradores "
					+ HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/allEntrenadores", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener listado de usuarios por tipo de usuario entrenador", notes = "Este metodo obtiene un listado de todos los usuarios entrenadores")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<List<Usuario>> getListadoUsuarioEntrenadores() throws AbedsBackendException {

		log.info("REST Solicitud GET de /usuario/allEntrenadores para obtener un listado de todos los usuarios entrenadores");

		List<Usuario> userEntrenadoresList = usuarioService.getListadoUsuarioEntrenadores();
		if (userEntrenadoresList != null && !userEntrenadoresList.isEmpty()) {
			log.info("REST Respuesta GET de  /usuario/allEntrenadores para obtener un listado de todos los usuarios entrenadores "
						+ HttpStatus.OK);
			return new ResponseEntity<List<Usuario>>(userEntrenadoresList, HttpStatus.OK);

		}

		log.info("REST Respuesta GET de  /usuario/allEntrenadores para obtener un listado de todos los usuarios entrenadores "
					+ HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/allRespSede", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener listado de usuarios por tipo de usuario responsable sede", notes = "Este metodo obtiene un listado de todos los usuarios responsable sede")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado")})
	public ResponseEntity<List<Usuario>> getListadoUsuarioRespSede() throws AbedsBackendException {

		log.info("REST Solicitud GET de /usuario/allRespSede para obtener un listado de todos los usuarios responsable sede");

		List<Usuario> userRespSede = usuarioService.getListadoUsuarioRespSede();
		if (userRespSede != null && !userRespSede.isEmpty()) {
			log.info("REST Respuesta GET de /usuario/allRespSede para obtener un listado de todos los usuarios responsable sede "
						+ HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Usuario>>(userRespSede, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/allRespSede para obtener un listado de todos los usuarios responsble sede "
					+ HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);	
	}

	//TODO
	@RequestMapping(value = "/allArbitros", method = RequestMethod.GET)
	public List<Usuario> getListadoUsuarioArbitros() throws AbedsBackendException {
		log.info("Inicio del metodo rest UsuarioRestController>>getListadoUsuarioArbitros....");
		List<Usuario> userArbitros = usuarioService.getListadoUsuarioArbitros();
		log.info("Finaliza del metodo rest UsuarioRestController>>getListadoUsuarioArbitros...");
		return userArbitros;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void delete(@PathVariable("id") Integer id) throws AbedsBackendException {
		log.info("Inicio del metodo rest UsuarioRestController>>delete....");
		usuarioService.deleteById(id);
		log.info("Finaliza del metodo rest UsuarioRestController>>delete...");
	}

	@RequestMapping(value = "/deleteByNif/{nif}", method = RequestMethod.POST)
	public void delete(@PathVariable("nif") String nif) throws AbedsBackendException {
		log.info("Inicio del metodo rest UsuarioRestController>>delete....");
		usuarioService.deleteByNif(nif);
		log.info("Finaliza del metodo rest UsuarioRestController>>delete...");

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(Usuario usuario) throws AbedsBackendException {
		log.info("Inicio del metodo rest UsuarioRestController>>delete....");
		usuarioService.delete(usuario);
		log.info("Finaliza del metodo rest UsuarioRestController>>delete...");

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(Usuario usuario) throws AbedsBackendException {
		log.info("Inicio del metodo rest UsuarioRestController>>save....");
		usuarioService.save(usuario);
		log.info("Finaliza del metodo rest UsuarioRestController>>save...");

	}
}
