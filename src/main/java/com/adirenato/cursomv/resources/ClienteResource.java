package com.adirenato.cursomv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adirenato.cursomv.domain.Pedido;
import com.adirenato.cursomv.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class ClienteResource {
	@Autowired
	PedidoService catService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido cat = catService.find(id);
		return ResponseEntity.ok().body(cat);
	}

}
