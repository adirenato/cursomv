package com.adirenato.cursomv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adirenato.cursomv.domain.Cliente;
import com.adirenato.cursomv.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class CategoriaResource {
	@Autowired
	ClienteService clienteService;
	@RequestMapping(value="/{id}", method =RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente cat = clienteService.buscar(id);  
		return ResponseEntity.ok().body(cat);
	}

}
