package com.example.apiTienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apiTienda.entities.PrendaRopa;
import com.example.apiTienda.exception.PrendaNotException;
import com.example.apiTienda.repository.PrendaRepository;

@Service
public class PrendaServiceImpl implements PrendaService {

	@Autowired
	private PrendaRepository prendaRepository;
	
	@Override
	public PrendaRopa agregarPrendaRopa(PrendaRopa prendaRopa) {
		
		return prendaRepository.save(prendaRopa);
	}

	@Override
	public PrendaRopa obtenerPrendaPorId(Long id) {
		return prendaRepository.findById(id).orElseThrow( () -> new PrendaNotException("Prenda no encontrada"));
	}

	@Override
	public PrendaRopa actualizarPrenda(Long id, PrendaRopa ropa) {
	    // Obtener la prenda existente por ID
	    PrendaRopa prenda = obtenerPrendaPorId(id);

	    // Actualdsdsizar los campos de la prenda existente con los valores de la nueva prenda
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

}
