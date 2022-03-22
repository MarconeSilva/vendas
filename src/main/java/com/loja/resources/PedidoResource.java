package com.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.domain.Pedido;
import com.loja.services.PedidoServico;

@RestController
@RequestMapping (value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoServico servico;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
}
