package com.example.apiTienda.entitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;

/**
 * Clase de pruebas para la entidad PrendaRopa.
 */
public class PrendaRopaTest {

    private PrendaRopa prendaRopa;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setUp() {
        prendaRopa = new PrendaRopa();
    }

    /**
     * Prueba para los métodos set y get de la propiedad Categoria.
     */
    @Test
    public void testSetAndGetCategoria() {
        // Configurar datos de prueba
        Categoria categoria = Categoria.Camiseta;

        // Ejecutar método a probar
        prendaRopa.setCategoria(categoria);

        // Verificar resultado esperado
        assertEquals(categoria, prendaRopa.getCategoria());
    }

    /**
     * Prueba para los métodos set y get de la propiedad Precio.
     */
    @Test
    public void testSetAndGetPrecio() {
        // Configurar datos de prueba
        Double precio = 20.0;

        // Ejecutar método a probar
        prendaRopa.setPrecio(precio);

        // Verificar resultado esperado
        assertEquals(precio, prendaRopa.getPrecio());
    }

    /**
     * Prueba para los métodos set y get de la propiedad Talla.
     */
    @Test
    public void testSetAndGetTalla() {
        // Configurar datos de prueba
        String talla = "M";

        // Ejecutar método a probar
        prendaRopa.setTalla(talla);

        // Verificar resultado esperado
        assertEquals(talla, prendaRopa.getTalla());
    }

    /**
     * Prueba para la validación de la propiedad Categoria (null).
     */
    @Test
    public void testCategoriaValidation() {
        // Configurar datos de prueba
        prendaRopa.setCategoria(null);

        // Suponiendo que tienes un método para validar la entidad
        // Puedes implementar este método de validación en tu servicio o clase de repositorio
        // y simularlo usando Mockito en un escenario del mundo real.
        // Para simplificar, usaré una invocación directa del método aquí.
        boolean isValid = validatePrendaRopa(prendaRopa);

        // Verificar resultado esperado
        assertEquals(false, isValid);
    }

    // Se pueden agregar pruebas similares para otras validaciones

    /**
     * Método privado para validar la entidad PrendaRopa.
     * @param prendaRopa La entidad a validar.
     * @return true si la validación es exitosa, false en caso contrario.
     */
    private boolean validatePrendaRopa(PrendaRopa prendaRopa) {
        // Implementa tu lógica de validación aquí
        // Para simplificar, devuelvo true si la categoría no es nula
        return prendaRopa.getCategoria() != null;
    }
}