package com.example.apiTienda.dto.response.error;

import java.util.Date;

/**
 * Clase que representa la estructura de respuesta detallada (DetailsResponse).
 * Contiene la información detallada sobre un mensaje de respuesta.
 */
public class DetailsResponse {

    /**
     * Marca de tiempo de la respuesta.
     */
	private Date timestamp;
	
	 /**
     * Mensaje de la respuesta.
     */
	private String message;
	
	/**
     * Detalles adicionales de la respuesta.
     */
	private String details;

    /**
     * Constructor que inicializa una instancia de DetailsResponse.
     *
     * @param timestamp Marca de tiempo de la respuesta.
     * @param message   Mensaje de la respuesta.
     * @param details   Detalles adicionales de la respuesta.
     */
	public DetailsResponse(Date timestamp, String message, String details) {
		super();
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
