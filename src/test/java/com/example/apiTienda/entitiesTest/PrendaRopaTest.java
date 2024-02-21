package com.example.apiTienda.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;

public class PrendaRopaTest {

    private PrendaRopa prendaRopa;

    @BeforeEach
    public void setUp() {
        prendaRopa = new PrendaRopa();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        prendaRopa.setId(id);
        assertEquals(id, prendaRopa.getId());
    }

    @Test
    public void testSetAndGetCategoria() {
        Categoria categoria = Categoria.Camiseta;
        prendaRopa.setCategoria(categoria);
        assertEquals(categoria, prendaRopa.getCategoria());
    }

    @Test
    public void testSetAndGetPrecio() {
        Double precio = 20.0;
        prendaRopa.setPrecio(precio);
        assertEquals(precio, prendaRopa.getPrecio());
    }

    @Test
    public void testSetAndGetTalla() {
        String talla = "M";
        prendaRopa.setTalla(talla);
        assertEquals(talla, prendaRopa.getTalla());
    }

    @Test
    public void testCategoriaValidation() {
        PrendaRopa prendaRopa = new PrendaRopa();
        prendaRopa.setCategoria(null);

        // Assuming you have a method to validate the entity
        // You can implement this validation method in your service or repository class
        // and mock it using Mockito in a real-world scenario.
        // For simplicity, I'll use a direct method invocation here.
        boolean isValid = validatePrendaRopa(prendaRopa);

        assertEquals(false, isValid);
    }

    // Similar tests can be added for other validations

    private boolean validatePrendaRopa(PrendaRopa prendaRopa) {
        // Implement your validation logic here
        // For simplicity, I'm returning true if the categoria is not null
        return prendaRopa.getCategoria() != null;
    }
}