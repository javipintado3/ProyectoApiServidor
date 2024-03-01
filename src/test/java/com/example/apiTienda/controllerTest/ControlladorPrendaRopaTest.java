package com.example.apiTienda.controllerTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.apiTienda.controller.ControlladorPrendaRopa;
import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.service.PrendaService;

/**
 * Clase de pruebas para ControlladorPrendaRopa.
 */
public class ControlladorPrendaRopaTest {

    @Mock
    private PrendaService prendaService;

    @InjectMocks
    private ControlladorPrendaRopa controller;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba para el método agregarPrenda.
     */
    @Test
    public void testAgregarPrenda() {
        PrendaRopa prendaRopa = new PrendaRopa();
        when(prendaService.agregarPrendaRopa(prendaRopa)).thenReturn(prendaRopa);

        ResponseEntity<PrendaRopa> response = controller.agregarPrenda(prendaRopa);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(prendaRopa, response.getBody());
    }

    /**
     * Prueba para el método obtenerPrendaPorId.
     */
    @Test
    public void testObtenerPrendaPorId() {
        Long id = 1L;
        PrendaRopa prendaRopa = new PrendaRopa();
        when(prendaService.obtenerPrendaPorId(id)).thenReturn(prendaRopa);

        ResponseEntity<PrendaRopa> response = controller.obtenerPrendaPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prendaRopa, response.getBody());
    }

    /**
     * Prueba para el método actualizarPrenda.
     */
    @Test
    public void testActualizarPrenda() {
        Long id = 1L;
        PrendaRopa prendaRopa = new PrendaRopa();
        when(prendaService.actualizarPrenda(id, prendaRopa)).thenReturn(prendaRopa);

        ResponseEntity<PrendaRopa> response = controller.actualizarPrenda(id, prendaRopa);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prendaRopa, response.getBody());
    }

    /**
     * Prueba para el método eliminarPrenda.
     */
    @Test
    public void testEliminarPrenda() {
        Long id = 1L;
        when(prendaService.obtenerPrendaPorId(id)).thenReturn(new PrendaRopa());

        ResponseEntity<String> response = controller.eliminarPrenda(id);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("Prenda eliminada con id: " + id, response.getBody());
        verify(prendaService, times(1)).eliminarPrenda(id);
    }

    /**
     * Prueba para el método listarTodasLasPrendas.
     */
    @Test
    public void testListarTodasLasPrendas() {
        int page = 0;
        int size = 10;
        String sortBy = "precio"; // Campo por el cual ordenar
        Page<PrendaRopa> prendas = mock(Page.class);
        when(prendaService.listarTodasLasPrendas(any())).thenReturn(prendas);

        ResponseEntity<Page<PrendaRopa>> response = controller.listarTodasLasPrendas(page, size, sortBy);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prendas, response.getBody());
    }

    /**
     * Prueba para el método listarPrendasPorCategoria.
     */
    @Test
    public void testListarPrendasPorCategoria() {
        Categoria categoria = Categoria.Sudadera;
        List<PrendaRopa> prendas = new ArrayList<>();
        when(prendaService.listarPorCategoria(categoria)).thenReturn(prendas);

        ResponseEntity<List<PrendaRopa>> response = controller.listarPrendasPorCategoria(categoria);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prendas, response.getBody());
    }
}