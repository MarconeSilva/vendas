package com.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.domain.Categoria;
import com.loja.services.CategoriaServico;

@RestController
@RequestMapping (value = "/categorias")
public class ClienteResource {
	
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
}
