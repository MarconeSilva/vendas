package com.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.domain.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> {
	
	

}
