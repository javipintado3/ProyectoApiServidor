package com.example.apiTienda.service.user;

import com.example.apiTienda.dto.request.SignUpRequest;
import com.example.apiTienda.dto.request.SigninRequest;
import com.example.apiTienda.dto.response.user.JwtAuthenticationResponse;

public interface AuthenticationService {
	/** REGISTRO */
    JwtAuthenticationResponse signup(SignUpRequest request);
    /** ACCESO a Token JWT */
    JwtAuthenticationResponse signin(SigninRequest request);
}
