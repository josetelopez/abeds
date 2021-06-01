package com.peretecorporate.abedsbackend.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbedsBaseException extends IOException {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@SuppressWarnings("unused")
	private final List<String>	errors;

	public AbedsBaseException(String mensaje) {
		super(mensaje);
		this.errors = new ArrayList<String>();
	}

	public List<String> getErrors() {
		return new ArrayList<>(this.errors);
	}

}
