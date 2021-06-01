package com.peretecorporate.abedsbackend.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbedsBackendNoTransactionalException extends IOException {

	private static final long	serialVersionUID	= 1L;
	private final List<String>	errors;

	public AbedsBackendNoTransactionalException(String message) {
		super(message);
		this.errors = new ArrayList<>();
	}

	public AbedsBackendNoTransactionalException(String message, List<String> errors) {
		super(message);
		this.errors = new ArrayList<>(errors);
	}

	public List<String> getErrors() {
		return new ArrayList<>(this.errors);
	}
}
