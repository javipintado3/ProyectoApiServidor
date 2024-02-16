package com.example.apiTienda.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.apiTienda.dto.response.user.UsuarioResponse;


public interface UserService {
    UserDetailsService userDetailsService();
    List<UsuarioResponse> getAllUsers();

}