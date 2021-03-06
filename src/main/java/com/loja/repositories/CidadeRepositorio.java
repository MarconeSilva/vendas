package com.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.domain.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {
	
	

}
