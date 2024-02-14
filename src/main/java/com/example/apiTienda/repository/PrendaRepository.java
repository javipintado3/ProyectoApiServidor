package com.example.apiTienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiTienda.entities.PrendaRopa;

@Repository
public interface PrendaRepository extends JpaRepository<PrendaRopa, Long> {

}
