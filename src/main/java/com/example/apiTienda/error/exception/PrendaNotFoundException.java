package com.example.apiTienda.error.exception;

public class PrendaNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PrendaNotFoundException(String message) {
		super(message);
	}

}
