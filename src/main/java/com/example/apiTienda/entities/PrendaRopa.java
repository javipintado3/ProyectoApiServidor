package com.example.apiTienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * Clase de entidad que representa una prenda de ropa.
 * Anotada con JPA para mapearla a la base de datos.
 */
@Data
@Entity
@Table(name = "prendaRopa")
public class PrendaRopa {

    /**
     * Identificador único de la prenda.
     */
  	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Categoría de la prenda. No puede estar vacía.
     */
    @NotBlank(message = "La categoría no puede estar vacía")
    private Categoria categoria;

    /**
     * Precio de la prenda. No puede estar vacío y debe contener solo números.
     */
    @NotBlank(message = "El precio no puede estar vacío")
    @Pattern(regexp = "[0-9]+", message = "El precio solo debe contener números")
    private Double precio;

    /**
     * Talla de la prenda. No puede estar vacía.
     */
    @NotBlank(message = "La talla no puede estar vacía")
    private String talla;
}
