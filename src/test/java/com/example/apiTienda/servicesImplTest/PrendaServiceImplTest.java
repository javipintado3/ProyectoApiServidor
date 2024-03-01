package com.example.apiTienda.servicesImplTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.error.exception.PrendaNotFoundException;
import com.example.apiTienda.repository.PrendaRepository;
import com.example.apiTienda.service.impl.PrendaServiceImpl;

/**
 * Clase de pruebas para la implementación de PrendaService.
 */
@SpringBootTest
public class PrendaServiceImplTest {

    private PrendaServiceImpl prendaService;

    @Mock
    private PrendaRepository prendaRepository;
    
    

    @BeforeEach
    void setUp() {
        // Inicializa los mocks anotados en esta instancia de prueba
        MockitoAnnotations.initMocks(this);
        prendaService = new PrendaServiceImpl(prendaRepository);
    }

    // Prueba para verificar el correcto funcionamiento de agregarPrendaRopa
    @Test
    void testAgregarPrendaRopa() {
        // Dado
        PrendaRopa prendaRopa = new PrendaRopa();
        when(prendaRepository.save(prendaRopa)).thenReturn(prendaRopa);

        // Cuando
        PrendaRopa result = prendaService.agregarPrendaRopa(prendaRopa);

        // Entonces
        assertEquals(prendaRopa, result, "El resultado debe coincidir con el mock");
        verify(prendaRepository).save(prendaRopa); // Verifica que se llame al método save del repositorio
    }

    // Prueba para verificar el correcto funcionamiento de obtenerPrendaPorId con ID existente
    @Test
    void testObtenerPrendaPorId_ExistingId() {
        // Dado
        Long id = 1L;
        PrendaRopa prendaRopa = new PrendaRopa();
        when(prendaRepository.findById(id)).thenReturn(Optional.of(prendaRopa));

        // Cuando
        PrendaRopa result = prendaService.obtenerPrendaPorId(id);

        // Entonces
        assertEquals(prendaRopa, result, "El resultado debe coincidir con el mock");
        verify(prendaRepository).findById(id); // Verifica que se llame al método findById del repositorio
    }

    // Prueba para verificar el correcto funcionamiento de obtenerPrendaPorId con ID no existente
    @Test
    void testObtenerPrendaPorId_NonExistingId() {
        // Dado
        Long id = 1L;
        when(prendaRepository.findById(id)).thenReturn(Optional.empty());

        // Cuando y Entonces
        assertThrows(PrendaNotFoundException.class, () -> prendaService.obtenerPrendaPorId(id));
    }

    // Prueba para verificar el correcto funcionamiento de actualizarPrenda
    @Test
    void testActualizarPrenda() {
        // Dado
        Long id = 1L;
        PrendaRopa existingPrenda = new PrendaRopa();
        existingPrenda.setId(id);
        existingPrenda.setCategoria(Categoria.Camiseta);
        when(prendaRepository.findById(id)).thenReturn(Optional.of(existingPrenda));

        PrendaRopa updatedPrenda = new PrendaRopa();
        updatedPrenda.setCategoria(Categoria.Patalones);
        updatedPrenda.setPrecio(25.0);
        updatedPrenda.setTalla("L");

        when(prendaRepository.save(existingPrenda)).thenReturn(updatedPrenda);

        // Cuando
        PrendaRopa result = prendaService.actualizarPrenda(id, updatedPrenda);

        // Entonces
        assertEquals(updatedPrenda, result, "El resultado debe coincidir con el mock");
        assertEquals(Categoria.Patalones, result.getCategoria(), "La categoría debe haber cambiado");
        verify(prendaRepository).findById(id); // Verifica que se llame al método findById del repositorio
        verify(prendaRepository).save(existingPrenda); // Verifica que se llame al método save del repositorio
    }

    // Prueba para verificar el correcto funcionamiento de eliminarPrenda
    @Test
    void testEliminarPrenda() {
        // Dado
        long id = 1L;

        // Cuando
        prendaService.eliminarPrenda(id);

        // Entonces
        verify(prendaRepository, times(1)).deleteById(id); // Verifica que se llame al método deleteById del repositorio
    }
}