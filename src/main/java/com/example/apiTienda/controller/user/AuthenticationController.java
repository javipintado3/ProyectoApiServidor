package com.example.apiTienda.controller.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiTienda.dto.request.SignUpRequest;
import com.example.apiTienda.dto.request.SigninRequest;
import com.example.apiTienda.dto.response.user.JwtAuthenticationResponse;
import com.example.apiTienda.service.user.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador que maneja las operaciones de autenticación, como registro (signup) e inicio de sesión (signin).
 * Este controlador responde a las solicitudes relacionadas con la autenticación y proporciona respuestas JWT.
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin // Esto permite el acceso CORS de cualquier origen a todos los endpoints en este controlador
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Maneja la solicitud de registro (signup) de un nuevo usuario.
     *
     * @param request Objeto SignUpRequest que contiene la información de registro del nuevo usuario.
     * @return ResponseEntity con la respuesta JwtAuthenticationResponse que contiene el token JWT.
     */
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    /**
     * Maneja la solicitud de inicio de sesión (signin) de un usuario existente.
     *
     * @param request Objeto SigninRequest que contiene la información de inicio de sesión del usuario.
     * @return ResponseEntity con la respuesta JwtAuthenticationResponse que contiene el token JWT.
     */
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}

