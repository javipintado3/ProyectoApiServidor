package com.example.apiTienda.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.apiTienda.entities.PrendaRopa;

public interface PrendaService {

    PrendaRopa agregarPrendaRopa(PrendaRopa prendaRopa);

    PrendaRopa obtenerPrendaPorId(Long id);

    PrendaRopa actualizarPrenda(Long id, PrendaRopa ropa);

    void eliminarPrenda(Long id);
    
    Page<PrendaRopa> listarTodasLasPrendas(Pageable pageable);
}
