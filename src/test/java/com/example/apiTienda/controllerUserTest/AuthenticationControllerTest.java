package com.example.apiTienda.controllerUserTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.apiTienda.controller.user.AuthenticationController;
import com.example.apiTienda.dto.request.SignUpRequest;
import com.example.apiTienda.dto.request.SigninRequest;
import com.example.apiTienda.dto.response.user.JwtAuthenticationResponse;
import com.example.apiTienda.service.user.AuthenticationService;

/**
 * Clase de pruebas para AuthenticationController.
 */
public class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba para el método signup.
     */
    @Test
    public void testSignup() {
        SignUpRequest signUpRequest = new SignUpRequest();
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse("token_here");

        when(authenticationService.signup(signUpRequest)).thenReturn(jwtAuthenticationResponse);

        ResponseEntity<JwtAuthenticationResponse> response = authenticationController.signup(signUpRequest);

        assertEquals(jwtAuthenticationResponse, response.getBody());
    }

    /**
     * Prueba para el método signin.
     */
    @Test
    public void testSignin() {
        SigninRequest signinRequest = new SigninRequest();
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse("token_here");

        when(authenticationService.signin(signinRequest)).thenReturn(jwtAuthenticationResponse);

        ResponseEntity<JwtAuthenticationResponse> response = authenticationController.signin(signinRequest);

        assertEquals(jwtAuthenticationResponse, response.getBody());
    }
}
