package com.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.domain.Cliente;
import com.loja.services.ClienteServico;

@RestController
@RequestMapping (value = "/clientes")
public class CategoriaResource {
	
	@Autowired
	private ClienteServico servico;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
}
