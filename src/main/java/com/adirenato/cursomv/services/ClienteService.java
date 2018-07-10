package com.adirenato.cursomv.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adirenato.cursomv.domain.Cliente;
import com.adirenato.cursomv.repositories.ClienteRepository;
import com.adirenato.cursomv.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	public Cliente buscar(Integer id) {
		Optional<Cliente> c = repo.findById(id);
		//função lambda
		return c.orElseThrow( () -> new ObjectNotFoundException ("Objeto não encontrado "+ id + ", tipo :"+ ClienteService.class.getName()) );
	}
	

}
