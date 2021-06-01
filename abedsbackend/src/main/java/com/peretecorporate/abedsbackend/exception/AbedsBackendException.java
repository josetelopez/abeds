package com.peretecorporate.abedsbackend.exception;

import java.util.ArrayList;
import java.util.List;

public class AbedsBackendException extends AbedsBaseException {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private final List<String>	errors;

	public AbedsBackendException(String mensaje) {
		super(mensaje);
		this.errors = new ArrayList<String>();
	}

	public AbedsBackendException(String message, List<String> errors) {
		super(message);
		this.errors = new ArrayList<>(errors);
	}

	public List<String> getErrors() {
		return new ArrayList<>(this.errors);
	}

}
