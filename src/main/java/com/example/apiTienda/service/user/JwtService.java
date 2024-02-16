package com.example.apiTienda.service.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	   String extractUserName(String token);
	    String generateToken(UserDetails userDetails);
	    boolean isTokenValid(String token, UserDetails userDetails);
}