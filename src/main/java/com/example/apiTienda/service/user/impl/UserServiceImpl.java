package com.example.apiTienda.service.user.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.apiTienda.dto.response.user.UsuarioResponse;
import com.example.apiTienda.repository.UserRepository;
import com.example.apiTienda.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de la entidad Usuario.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
	@Override
	public List<UsuarioResponse> getAllUsers() {
		List<UsuarioResponse> allUsers =  userRepository.findAll().stream()
			    .map(usuario -> new UsuarioResponse(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getRoles().toString()))
			    .collect(Collectors.toList());
		 return allUsers;
	}
}
