package com.example.apiTienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apiTienda.entities.Categoria;
import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.error.exception.PrendaNotFoundException;

import com.example.apiTienda.repository.PrendaRepository;
import com.example.apiTienda.service.PrendaService;

/**
 * Implementación del servicio de la entidad PrendaRopa.
 */
@Service
public class PrendaServiceImpl implements PrendaService {

	
	private PrendaRepository prendaRepository;
	
	public PrendaServiceImpl(PrendaRepository prendaRepository) {
		this.prendaRepository = prendaRepository;
	}
	
	@Override
	public PrendaRopa agregarPrendaRopa(PrendaRopa prendaRopa) {
		
		return prendaRepository.save(prendaRopa);
	}

	@Override
	public PrendaRopa obtenerPrendaPorId(Long id) {
		return prendaRepository.findById(id).orElseThrow( () -> new PrendaNotFoundException("Prenda no encontrada"));
	}

	@Override
	public PrendaRopa actualizarPrenda(Long id, PrendaRopa ropa) {
	    // Obtener la prenda existente por ID
	    PrendaRopa prenda = obtenerPrendaPorId(id);

	    // Actualizar los campos de la prenda existente con los valores de la nueva prenda
	    prenda.setCategoria(ropa.getCategoria());
	    prenda.setPrecio(ropa.getPrecio());
	    prenda.setTalla(ropa.getTalla());

	    // Guardar la prenda actualizada en la base de datos
	    return prendaRepository.save(prenda);
	}

	@Override
	public void eliminarPrenda(Long id) {
		prendaRepository.deleteById(id);
		
	}

	@Override
	public Page<PrendaRopa> listarTodasLasPrendas(Pageable pageable) {
		return prendaRepository.findAll(pageable);
	}

	@Override
	public List<PrendaRopa> listarPorCategoria(Categoria categoria) {
		return prendaRepository.findByCategoria(categoria);
	}


}
