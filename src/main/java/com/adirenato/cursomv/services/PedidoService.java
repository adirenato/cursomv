package com.adirenato.cursomv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adirenato.cursomv.domain.Pedido;
import com.adirenato.cursomv.repositories.PedidoRepository;
import com.adirenato.cursomv.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> c = repo.findById(id);
		// função lambda
		return c.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado " + id + ", tipo :" + PedidoService.class.getName()));
	}

}
