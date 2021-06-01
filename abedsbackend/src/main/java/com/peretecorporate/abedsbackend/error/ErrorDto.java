package com.peretecorporate.abedsbackend.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import com.peretecorporate.abedsbackend.enumerados.ETipoError;

public class ErrorDto implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private String				message;
	private List<String>		errors;
	private StackTraceElement[]	stackTrace;
	ETipoError					tipo				= ETipoError.GENERIC;
	private Date				timestamp;
	private String				status;

	public ErrorDto() {
	}

	public ErrorDto(String message, List<String> errors, StackTraceElement[] stackTrace, ETipoError tipo,
				Date timestamp, String status) {
		this.message = message;
		this.errors = errors;
		this.stackTrace = stackTrace;
		this.tipo = tipo;
		this.timestamp = timestamp;
		this.status = status;
	}

	public ETipoError getTipo() {
		return this.tipo;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}

	public void setTipo(ETipoError tipo) {
		this.tipo = tipo;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof ErrorDto)) return false;
		ErrorDto other = (ErrorDto) o;
		if (!other.canEqual(this)) return false;
		Object this$message = getMessage(), other$message = other.getMessage();
		if ((this$message == null) ? (other$message != null) : !this$message.equals(other$message)) return false;
		Object this$errors = (Object) getErrors(), other$errors = (Object) other.getErrors();
		if ((this$errors == null) ? (other$errors != null) : !this$errors.equals(other$errors)) return false;
		if (!Arrays.deepEquals((Object[]) getStackTrace(), (Object[]) other.getStackTrace())) return false;
		Object this$tipo = getTipo(), other$tipo = other.getTipo();
		if ((this$tipo == null) ? (other$tipo != null) : !this$tipo.equals(other$tipo)) return false;
		Object this$timestamp = getTimestamp(), other$timestamp = other.getTimestamp();
		if ((this$timestamp == null) ? (other$timestamp != null) : !this$timestamp.equals(other$timestamp))
			return false;
		Object this$status = getStatus(), other$status = other.getStatus();
		return !((this$status == null) ? (other$status != null) : !this$status.equals(other$status));
	}

	protected boolean canEqual(Object other) {
		return other instanceof ErrorDto;
	}

	public int hashCode() {
		int PRIME = 59;
		int result = 1;
		Object $message = getMessage();
		result = result * 59 + (($message == null) ? 43 : $message.hashCode());
		Object $errors = (Object) getErrors();
		result = result * 59 + (($errors == null) ? 43 : $errors.hashCode());
		result = result * 59 + Arrays.deepHashCode((Object[]) getStackTrace());
		Object $tipo = getTipo();
		result = result * 59 + (($tipo == null) ? 43 : $tipo.hashCode());
		Object $timestamp = getTimestamp();
		result = result * 59 + (($timestamp == null) ? 43 : $timestamp.hashCode());
		Object $status = getStatus();
		return result * 59 + (($status == null) ? 43 : $status.hashCode());
	}

	public String toString() {
		return "ErrorDto(message=" + getMessage() + ", errors=" + getErrors() + ", stackTrace="
					+ Arrays.deepToString((Object[]) getStackTrace()) + ", tipo=" + getTipo() + ", timestamp="
					+ getTimestamp() + ", status=" + getStatus() + ")";
	}

	public StackTraceElement[] getStackTrace() {
		return this.stackTrace;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public String getStatus() {
		return this.status;
	}

	public String getMessage() {
		String result = "";
		if (this.message != null) {
			result = Jsoup.clean(this.message, Whitelist.simpleText());
		}
		return result;
	}

	public List<String> getErrors() {
		List<String> result = new ArrayList<>();

		if (this.errors != null) {
			this.errors.stream().forEach(e -> result.add(Jsoup.clean(e, Whitelist.simpleText())));
		}
		return result;
	}

}
