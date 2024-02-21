package com.example.apiTienda.entitiesTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Collection; // Import java.util.Collection

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.apiTienda.entities.Role;
import com.example.apiTienda.entities.Usuario;


public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
    }


    @Test
    public void testSetAndGetFirstName() {
        String firstName = "Manuel";
        usuario.setFirstName(firstName);
        assertEquals(firstName, usuario.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String lastName = "Alonso";
        usuario.setLastName(lastName);
        assertEquals(lastName, usuario.getLastName());
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "manuel.alonso@example.com";
        usuario.setEmail(email);
        assertEquals(email, usuario.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "password123";
        usuario.setPassword(password);
        assertEquals(password, usuario.getPassword());
    }

    @Test
    public void testSetAndGetRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        roles.add(Role.ROLE_ADMIN);
        usuario.setRoles(roles);
        assertEquals(roles, usuario.getRoles());
    }

    @Test
    public void testGetAuthorities() {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        roles.add(Role.ROLE_ADMIN);
        usuario.setRoles(roles);

        // Assuming you have a method to validate the entity
        // You can implement this validation method in your service or repository class
        // and mock it using Mockito in a real-world scenario.
        // For simplicity, I'll use a direct method invocation here.
        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();

        assertEquals(2, authorities.size());
        assertEquals(true, authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertEquals(true, authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }



}

