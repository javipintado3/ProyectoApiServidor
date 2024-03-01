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


/**
 * Clase de pruebas para la entidad Usuario.
 */
public class UsuarioTest {

    private Usuario usuario;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
    }

    /**
     * Prueba para los métodos set y get de la propiedad FirstName.
     */
    @Test
    public void testSetAndGetFirstName() {
        // Configurar datos de prueba
        String firstName = "Manuel";

        // Ejecutar método a probar
        usuario.setFirstName(firstName);

        // Verificar resultado esperado
        assertEquals(firstName, usuario.getFirstName());
    }

    /**
     * Prueba para los métodos set y get de la propiedad LastName.
     */
    @Test
    public void testSetAndGetLastName() {
        // Configurar datos de prueba
        String lastName = "Alonso";

        // Ejecutar método a probar
        usuario.setLastName(lastName);

        // Verificar resultado esperado
        assertEquals(lastName, usuario.getLastName());
    }

    /**
     * Prueba para los métodos set y get de la propiedad Email.
     */
    @Test
    public void testSetAndGetEmail() {
        // Configurar datos de prueba
        String email = "manuel.alonso@example.com";

        // Ejecutar método a probar
        usuario.setEmail(email);

        // Verificar resultado esperado
        assertEquals(email, usuario.getEmail());
    }

    /**
     * Prueba para los métodos set y get de la propiedad Password.
     */
    @Test
    public void testSetAndGetPassword() {
        // Configurar datos de prueba
        String password = "password123";

        // Ejecutar método a probar
        usuario.setPassword(password);

        // Verificar resultado esperado
        assertEquals(password, usuario.getPassword());
    }

    /**
     * Prueba para los métodos set y get de la propiedad Roles.
     */
    @Test
    public void testSetAndGetRoles() {
        // Configurar datos de prueba
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        roles.add(Role.ROLE_ADMIN);

        // Ejecutar método a probar
        usuario.setRoles(roles);

        // Verificar resultado esperado
        assertEquals(roles, usuario.getRoles());
    }

    /**
     * Prueba para el método getAuthorities.
     */
    @Test
    public void testGetAuthorities() {
        // Configurar datos de prueba
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        roles.add(Role.ROLE_ADMIN);
        usuario.setRoles(roles);

        // Suponiendo que tienes un método para validar la entidad
        // Puedes implementar este método de validación en tu servicio o clase de repositorio
        // y simularlo usando Mockito en un escenario del mundo real.
        // Para simplificar, usaré una invocación directa del método aquí.
        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();

        // Verificar resultado esperado
        assertEquals(2, authorities.size());
        assertEquals(true, authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertEquals(true, authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }
}

