package com.example.apiTienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.service.PrendaService;

@RestController
@RequestMapping("/api/v1/prendas")
public class ControlladorPrendaRopa {

    @Autowired
    private PrendaService prendaService;

    // Crear una nueva prenda de ropa
    @PostMapping
    public ResponseEntity<PrendaRopa> agregarPrenda(@RequestBody PrendaRopa prendaRopa) {
        PrendaRopa nuevaPrenda = prendaService.agregarPrendaRopa(prendaRopa);
        return new ResponseEntity<>(nuevaPrenda, HttpStatus.CREATED);
    }

    // Obtener una prenda por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PrendaRopa> obtenerPrendaPorId(@PathVariable Long id) {
        PrendaRopa prenda = prendaService.obtenerPrendaPorId(id);
        return new ResponseEntity<>(prenda, HttpStatus.OK);
    }

    // Actualizar una prenda por su ID
    @PutMapping("/{id}")
    public ResponseEntity<PrendaRopa> actualizarPrenda(@PathVariable Long id, @RequestBody PrendaRopa prendaRopa) {
        PrendaRopa prendaActualizada = prendaService.actualizarPrenda(id, prendaRopa);
        return new ResponseEntity<>(prendaActualizada, HttpStatus.OK);
    }

    // Eliminar una prenda por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrenda(@PathVariable Long id) {
        prendaService.eliminarPrenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping
    public ResponseEntity<Page<PrendaRopa>> listarTodasLasPrendas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PrendaRopa> prendas = prendaService.listarTodasLasPrendas(pageable);
        return new ResponseEntity<>(prendas, HttpStatus.OK);
    }
}
