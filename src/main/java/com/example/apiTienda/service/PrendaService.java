package com.example.apiTienda.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;

/**
 * Interfaz que define los métodos de servicio para operaciones relacionadas con la entidad PrendaRopa.
 */
public interface PrendaService {

    /**
     * Agrega una nueva prenda de ropa.
     *
     * @param prendaRopa Objeto PrendaRopa que se va a agregar.
     * @return La prenda de ropa agregada.
     */
    PrendaRopa agregarPrendaRopa(PrendaRopa prendaRopa);

    /**
     * Obtiene una prenda de ropa por su id
     *
     * @param id Id de la prenda de ropa.
     * @return La prenda de ropa correspondiente al Id proporcionado.
     */
    PrendaRopa obtenerPrendaPorId(Long id);

    /**
     * Actualiza una prenda de ropa existente.
     *
     * @param id      Id de la prenda de ropa que se va a actualizar.
     * @param ropa    Objeto PrendaRopa con los nuevos datos.
     * @return La prenda de ropa actualizada.
     */
    PrendaRopa actualizarPrenda(Long id, PrendaRopa ropa);

    /**
     * Elimina una prenda de ropa por su Id.
     *
     * @param id Id de la prenda de ropa que se va a eliminar.
     */
    void eliminarPrenda(Long id);

    /**
     * Obtiene una página de prendas de ropa según los parámetros de paginación.
     *
     * @param pageable Parámetros de paginación.
     * @return Página de prendas de ropa.
     */
    Page<PrendaRopa> listarTodasLasPrendas(Pageable pageable);

    /**
     * Lista todas las prendas de ropa que pertenecen a una categoría específica.
     *
     * @param categoria Categoría de las prendas de ropa a listar.
     * @return Lista de prendas de ropa de la categoría especificada.
     */
    List<PrendaRopa> listarPorCategoria(Categoria categoria);
}
