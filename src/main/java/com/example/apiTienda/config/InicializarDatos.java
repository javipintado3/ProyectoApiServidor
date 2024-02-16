package com.example.apiTienda.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.entities.Role;
import com.example.apiTienda.entities.Usuario;
import com.example.apiTienda.repository.PrendaRepository;
import com.example.apiTienda.repository.UserRepository;
import com.github.javafaker.Faker;

@Component
public class InicializarDatos implements CommandLineRunner {

    @Autowired
    private PrendaRepository prendaRepository;
    
    @Autowired
    private UserRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

    	try {
    		// Usuario 1 - Rol USER
            Usuario usuario1 = new Usuario();
            usuario1.setFirstName("Manuel");
            usuario1.setLastName("Alonso");
            usuario1.setEmail("manuel.alonso@example.com");
            usuario1.setPassword(passwordEncoder.encode("password123"));
            usuario1.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario1);

            // Usuario 2 - Rol ADMIN
            Usuario usuario2 = new Usuario();
            usuario2.setFirstName("Enrique");
            usuario2.setLastName("Casimiro");
            usuario2.setEmail("enrique.casimiro@example.com");
            usuario2.setPassword(passwordEncoder.encode("password456"));
            usuario2.getRoles().add(Role.ROLE_ADMIN);
            usuarioRepository.save(usuario2);

            // Usuario 3 - Rol USER
            Usuario usuario3 = new Usuario();
            usuario3.setFirstName("Andres");
            usuario3.setLastName("Baena");
            usuario3.setEmail("andres.baena@example.com");
            usuario3.setPassword(passwordEncoder.encode("password789"));
            usuario3.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario3);
            
            
  
    	}catch(Exception e) {
    		
    	}
    	
        Faker faker = new Faker(new Locale("es"));

        // Generar 10 prendas
        for (int i = 1; i <= 10; i++) {
            PrendaRopa prenda = new PrendaRopa();
            prenda.setCategoria(obtenerCategoriaAleatoria(faker)); // Asignar categoría aleatoria
            prenda.setPrecio(faker.number().randomDouble(2, 10, 100)); // Precio aleatorio
            prenda.setTalla(obtenerTallaAleatoria(faker)); // Talla aleatoria

            // Guardar la prenda en la base de datos
            prendaRepository.save(prenda);
        }
    }

    private Categoria obtenerCategoriaAleatoria(Faker faker) {
        // Obtener una categoría aleatoria de la enumeración Categoria
        Categoria[] categorias = Categoria.values();
        int indiceCategoriaAleatoria = faker.random().nextInt(categorias.length);
        return categorias[indiceCategoriaAleatoria];
    }

    private String obtenerTallaAleatoria(Faker faker) {
        // Obetener talla aleatoria
        return faker.options().option("S", "M", "L", "XL");
    }
}
