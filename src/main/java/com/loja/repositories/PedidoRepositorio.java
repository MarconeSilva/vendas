package com.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.domain.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
	
	

}
