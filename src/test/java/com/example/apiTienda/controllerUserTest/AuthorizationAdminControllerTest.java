package com.example.apiTienda.controllerUserTest;

import com.example.apiTienda.controller.user.AuthorizationAdminController;
import com.example.apiTienda.dto.response.user.UsuarioResponse;
import com.example.apiTienda.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Clase de pruebas para AuthorizationAdminController.
 */
public class AuthorizationAdminControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthorizationAdminController authorizationAdminController;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba para el método showUsers.
     */
    @Test
    public void testShowUsers() {
        // Preparar datos de prueba
        List<UsuarioResponse> userList = Collections.singletonList(new UsuarioResponse("John", "Doe", "john.doe@example.com", "ROLE_USER"));
        when(userService.getAllUsers()).thenReturn(userList);

        // Ejecutar el método a probar
        ResponseEntity<List<UsuarioResponse>> responseEntity = authorizationAdminController.showUsers();

        // Verificar los resultados esperados
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userList, responseEntity.getBody());
    }
}
