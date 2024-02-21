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

public class AuthorizationControllerTest {

    private AuthorizationController authorizationController;

    @BeforeEach
    public void setUp() {
        authorizationController = new AuthorizationController();
    }

    @Test
    public void testSayHello() {
        ResponseEntity<String> response = authorizationController.sayHello();
        assertEquals("Here is your resource", response.getBody());
    }

    @Test
    public void testMiPerfil() {
        // Create a mock Usuario for testing
        Usuario usuario = mock(Usuario.class);
        when(usuario.getFirstName()).thenReturn("John");
        when(usuario.getLastName()).thenReturn("Doe");
        when(usuario.getEmail()).thenReturn("john.doe@example.com");
        when(usuario.getRoles()).thenReturn(Set.of(Role.ROLE_USER));

        // Set the mock Usuario as the authentication principal
        ResponseEntity<UsuarioResponse> response = authorizationController.miPerfil(usuario);

        // Verify that the response contains the expected user details
        UsuarioResponse expectedResponse = new UsuarioResponse("John", "Doe", "john.doe@example.com", "[ROLE_USER]");
        assertEquals(expectedResponse, response.getBody());
    }
}

