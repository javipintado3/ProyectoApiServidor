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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}
    
    
}
