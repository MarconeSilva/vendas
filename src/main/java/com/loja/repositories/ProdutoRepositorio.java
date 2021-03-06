package com.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.domain.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
	
	

}
