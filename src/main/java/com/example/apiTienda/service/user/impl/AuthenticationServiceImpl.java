package com.example.apiTienda.service.user.impl;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.apiTienda.dto.request.SignUpRequest;
import com.example.apiTienda.dto.request.SigninRequest;
import com.example.apiTienda.dto.response.user.JwtAuthenticationResponse;
import com.example.apiTienda.entities.Role;
import com.example.apiTienda.entities.Usuario;
import com.example.apiTienda.repository.UserRepository;
import com.example.apiTienda.service.user.AuthenticationService;
import com.example.apiTienda.service.user.JwtService;

import lombok.Builder;

/**
 * Implementación del servicio de autenticación.
 */
@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param userRepository        Repositorio de usuarios.
     * @param passwordEncoder       Codificador de contraseñas.
     * @param jwtService            Servicio JWT.
     * @param authenticationManager Administrador de autenticación.
     */
    public AuthenticationServiceImpl(UserRepository userRepository,
                                     PasswordEncoder passwordEncoder,
                                     JwtService jwtService,
                                     AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Registra un nuevo usuario y devuelve un token JWT.
     *
     * @param request Datos del usuario a registrar.
     * @return Respuesta de autenticación que contiene el token JWT.
     */
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        Usuario user = new Usuario();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(Role.ROLE_USER); // Asegúrate de que Role.USER esté definido correctamente
        userRepository.save(user);

        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    /**
     * Realiza la autenticación del usuario y devuelve un token JWT.
     *
     * @param request Datos del usuario para la autenticación.
     * @return Respuesta de autenticación que contiene el token JWT.
     */
    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        Usuario user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}

