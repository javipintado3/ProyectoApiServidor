package com.example.apiTienda.error.exception;

/**
 * Excepción personalizada para indicar que no se ha encontrado una prenda.
 */
public class PrendaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message Mensaje de error que describe la excepción.
     */
    public PrendaNotFoundException(String message) {
        super(message);
    }
}

