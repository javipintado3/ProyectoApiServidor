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


@Data
@Entity
@Table(name = "prendaRopa")
public class PrendaRopa {

  	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  	
    @NotBlank(message = "La categoria no puede estar vacia")
    private Categoria categoria;

    @NotBlank(message = "El precio no puede estar vacio")
    @Pattern(regexp = "[0-9]+", message = "El Precio solo debe contener números")
    private Double precio;
    
    @NotBlank(message = "La talla no puede estar vacía")
    private String talla;

	
    
    
}
