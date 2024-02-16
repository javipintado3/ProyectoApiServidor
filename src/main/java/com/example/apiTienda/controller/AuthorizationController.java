package com.example.apiTienda.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiTienda.dto.response.user.UsuarioResponse;
import com.example.apiTienda.entities.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resources")
@RequiredArgsConstructor
public class AuthorizationController {
private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

	
    @GetMapping
    public ResponseEntity<String> sayHello() {
    	logger.info("## AuthorizationController :: sayHello" );
        return ResponseEntity.ok("Here is your resource");
    }
    
    @GetMapping("/perfil")
    public ResponseEntity<UsuarioResponse> miPerfil(@AuthenticationPrincipal Usuario usuario) {
    	logger.info("## AuthorizationController :: miPerfil" );
    	
    	UsuarioResponse userResponse = new UsuarioResponse(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getRoles().toString());
    	
    	return  ResponseEntity.ok(userResponse);
    }
}
