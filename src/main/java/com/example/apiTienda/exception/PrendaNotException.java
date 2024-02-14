package com.example.apiTienda.exception;

public class PrendaNotException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PrendaNotException(String mensaje) {
		super(mensaje);
	}

}
