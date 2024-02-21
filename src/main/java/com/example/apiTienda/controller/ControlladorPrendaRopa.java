package com.example.apiTienda.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.service.PrendaService;

@RestController
@RequestMapping("/api/v1/prendas")
public class ControlladorPrendaRopa {

    @Autowired
    private PrendaService prendaService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PrendaRopa> agregarPrenda(@RequestBody PrendaRopa prendaRopa) {
        PrendaRopa nuevaPrenda = prendaService.agregarPrendaRopa(prendaRopa);
        return new ResponseEntity<>(nuevaPrenda, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<PrendaRopa> obtenerPrendaPorId(@PathVariable Long id) {
        PrendaRopa prenda = prendaService.obtenerPrendaPorId(id);
        return new ResponseEntity<>(prenda, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PrendaRopa> actualizarPrenda(@PathVariable Long id, @RequestBody PrendaRopa prendaRopa) {
        PrendaRopa prendaActualizada = prendaService.actualizarPrenda(id, prendaRopa);
        return new ResponseEntity<>(prendaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> eliminarPrenda(@PathVariable Long id) {
        prendaService.obtenerPrendaPorId(id);
    	prendaService.eliminarPrenda(id);
        return new ResponseEntity<>("Prenda eliminada con id: " + id,HttpStatus.ACCEPTED);
        

    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<PrendaRopa>> listarTodasLasPrendas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PrendaRopa> prendas = prendaService.listarTodasLasPrendas(pageable);
        return new ResponseEntity<>(prendas, HttpStatus.OK);
    }
}
