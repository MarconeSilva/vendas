package com.loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.domain.Cliente;
import com.loja.repositories.ClienteRepositorio;
import com.loja.services.exception.ObjectNotFoundException;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! Id:" + id + 
				", Tipo: " + Cliente.class.getName()));
		
	}

}
