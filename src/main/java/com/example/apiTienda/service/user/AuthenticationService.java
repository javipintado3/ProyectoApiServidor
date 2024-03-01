package com.example.apiTienda.service.user;

import com.example.apiTienda.dto.request.SignUpRequest;
import com.example.apiTienda.dto.request.SigninRequest;
import com.example.apiTienda.dto.response.user.JwtAuthenticationResponse;

/**
 * Interfaz para el servicio de autenticación.
 */
public interface AuthenticationService {
    
    /**
     * Registro de un nuevo usuario y generación del token JWT correspondiente.
     *
     * @param request Detalles de registro del usuario.
     * @return Respuesta que contiene el token JWT.
     */
    JwtAuthenticationResponse signup(SignUpRequest request);

    /**
     * Autenticación de un usuario y generación del token JWT correspondiente.
     *
     * @param request Detalles de inicio de sesión del usuario.
     * @return Respuesta que contiene el token JWT.
     */
    JwtAuthenticationResponse signin(SigninRequest request);
}
