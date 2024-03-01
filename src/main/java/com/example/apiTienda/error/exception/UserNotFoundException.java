package com.example.apiTienda.error.exception;

/**
 * Excepción personalizada para indicar que no se ha encontrado un usuario.
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message Mensaje de error que describe la excepción.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}

