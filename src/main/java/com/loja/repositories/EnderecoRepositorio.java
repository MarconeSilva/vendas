package com.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.domain.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {
	
	

}
