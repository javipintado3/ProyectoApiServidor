package com.example.apiTienda.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad PrendaRopa.
 */
@Repository
public interface PrendaRepository extends JpaRepository<PrendaRopa, Long> {

    /**
     * Encuentra todas las prendas por una categoría específica.
     *
     * @param categoria Categoría por la cual filtrar las prendas.
     * @return Lista de prendas que pertenecen a la categoría especificada.
     */
    List<PrendaRopa> findByCategoria(Categoria categoria);
}
