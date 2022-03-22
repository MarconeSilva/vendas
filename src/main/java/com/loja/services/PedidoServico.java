package com.loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.domain.Pedido;
import com.loja.repositories.PedidoRepositorio;
import com.loja.services.exception.ObjectNotFoundException;

@Service
public class PedidoServico {
	
	@Autowired
	private PedidoRepositorio repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! Id:" + id + 
				", Tipo: " + Pedido.class.getName()));
		
	}

}
