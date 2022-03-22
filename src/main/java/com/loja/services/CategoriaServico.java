package com.loja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.domain.Categoria;
import com.loja.repositories.CategoriaRepositorio;
import com.loja.services.exception.ObjectNotFoundException;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositorio repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! Id:" + id + 
				", Tipo: " + Categoria.class.getName()));
		
	}

}
