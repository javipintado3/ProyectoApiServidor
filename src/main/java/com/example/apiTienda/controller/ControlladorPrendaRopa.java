package com.example.apiTienda.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.service.PrendaService;

/**
 * Controlador para gestionar operaciones relacionadas con prendas de ropa.
 */
@RestController
@RequestMapping("/api/v1/prendas")
public class ControlladorPrendaRopa {

    @Autowired
    private PrendaService prendaService;

    /**
     * Agrega una nueva prenda de ropa.
     *
     * @param prendaRopa La información de la nueva prenda.
     * @return ResponseEntity con el resultado de la operación y la nueva prenda creada.
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PrendaRopa> agregarPrenda(@RequestBody PrendaRopa prendaRopa) {
        PrendaRopa nuevaPrenda = prendaService.agregarPrendaRopa(prendaRopa);
        return new ResponseEntity<>(nuevaPrenda, HttpStatus.CREATED);
    }

    /**
     * Obtiene la información de una prenda por su ID.
     *
     * @param id El ID de la prenda que se desea obtener.
     * @return ResponseEntity con el resultado de la operación y la información de la prenda.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<PrendaRopa> obtenerPrendaPorId(@PathVariable Long id) {
        PrendaRopa prenda = prendaService.obtenerPrendaPorId(id);
        return new ResponseEntity<>(prenda, HttpStatus.OK);
    }

    /**
     * Actualiza la información de una prenda ya creada.
     *
     * @param id          El ID de la prenda que se desea actualizar.
     * @param prendaRopa  La nueva información de la prenda.
     * @return ResponseEntity con el resultado de la operación y la prenda actualizada.
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PrendaRopa> actualizarPrenda(@PathVariable Long id, @RequestBody PrendaRopa prendaRopa) {
        PrendaRopa prendaActualizada = prendaService.actualizarPrenda(id, prendaRopa);
        return new ResponseEntity<>(prendaActualizada, HttpStatus.OK);
    }

    /**
     * Elimina una prenda por su ID.
     *
     * @param id El ID de la prenda que se desea eliminar.
     * @return ResponseEntity con el resultado de la operación.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> eliminarPrenda(@PathVariable Long id) {
        prendaService.obtenerPrendaPorId(id);
    	prendaService.eliminarPrenda(id);
        return new ResponseEntity<>("Prenda eliminada con id: " + id,HttpStatus.ACCEPTED);
        

    }

    /**
     * Obtiene una lista paginada de todas las prendas de ropa ordenada por precio de menor a mayor.
     *
     * @param page   Número de página.
     * @param size   Tamaño de la página.
     * @param sortBy Campo por el cual ordenar la lista (opcional, por defecto "precio").
     * @return ResponseEntity con el resultado de la operación y la lista paginada de prendas.
     */
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<PrendaRopa>> listarTodasLasPrendas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "precio") String sortBy) { // Nuevo parámetro para indicar el campo de ordenación
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending()); // Se agrega el campo de ordenación

        Page<PrendaRopa> prendas = prendaService.listarTodasLasPrendas(pageable);

        return new ResponseEntity<>(prendas, HttpStatus.OK);
    }
    
    /**
     * Obtiene una lista de prendas de ropa por una categoría específica.
     *
     * @param categoria La categoría por la cual filtrar las prendas.
     * @return ResponseEntity con el resultado de la operación y la lista de prendas por categoría.
     */
    @GetMapping("/categoria/{categoria}")
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<PrendaRopa>> listarPrendasPorCategoria(@PathVariable Categoria categoria) {
        List<PrendaRopa> prendas = prendaService.listarPorCategoria(categoria);
        return new ResponseEntity<>(prendas, HttpStatus.OK);
    }


}
