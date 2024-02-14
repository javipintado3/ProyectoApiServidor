package com.example.apiTienda.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.repository.PrendaRepository;
import com.github.javafaker.Faker;

@Component
public class InicializarDatos implements CommandLineRunner {

    @Autowired
    private PrendaRepository prendaRepository;

    @Override
    public void run(String... args) throws Exception {

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
