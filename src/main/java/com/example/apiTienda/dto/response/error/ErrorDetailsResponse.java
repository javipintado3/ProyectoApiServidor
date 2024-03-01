package com.example.apiTienda.dto.response.error;

import java.util.Date;

/**
 * Clase que representa la estructura de respuesta detallada para errores (ErrorDetailsResponse).
 * Contiene la información detallada sobre un error en la respuesta.
 */
public class ErrorDetailsResponse {
	
	/**
     * Marca de tiempo del error.
     */
    private Date timestamp;

    /**
     * Mensaje del error.
     */
    private String message;

    /**
     * Detalles adicionales del error.
     */
    private String details;

    /**
     * Constructor que inicializa una instancia de ErrorDetailsResponse.
     *
     * @param timestamp Marca de tiempo del error.
     * @param message   Mensaje del error.
     * @param details   Detalles adicionales del error.
     */
    public ErrorDetailsResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
