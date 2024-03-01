package com.example.apiTienda.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.example.apiTienda.controller.AuthorizationController;
import com.example.apiTienda.dto.response.user.UsuarioResponse;
import com.example.apiTienda.entities.Role;
import com.example.apiTienda.entities.Usuario;

/**
 * Clase de pruebas para AuthorizationController.
 */
public class AuthorizationControllerTest {

    private AuthorizationController authorizationController;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setUp() {
        authorizationController = new AuthorizationController();
    }

    /**
     * Prueba para el método sayHello.
     */
    @Test
    public void testSayHello() {
        // Verificar que el método sayHello devuelve la cadena esperada
        ResponseEntity<String> response = authorizationController.sayHello();
        assertEquals("Here is your resource", response.getBody());
    }

    /**
     * Prueba para el método miPerfil.
     */
    @Test
    public void testMiPerfil() {
        // Crear un Usuario simulado para las pruebas
        Usuario usuario = mock(Usuario.class);
        when(usuario.getFirstName()).thenReturn("Manuel");
        when(usuario.getLastName()).thenReturn("Alonso");
        when(usuario.getEmail()).thenReturn("manuel.alonso@example.com");
        when(usuario.getRoles()).thenReturn(Set.of(Role.ROLE_USER));

        // Establecer el Usuario simulado como el principal de la autenticación
        // y realizar la prueba
        ResponseEntity<UsuarioResponse> response = authorizationController.miPerfil(usuario);

        // Verificar que la respuesta contenga los detalles de usuario esperados
        UsuarioResponse expectedResponse = new UsuarioResponse("Manuel", "Alonso", "manuel.alonso@example.com", "[ROLE_USER]");
        assertEquals(expectedResponse, response.getBody());
    }
}

