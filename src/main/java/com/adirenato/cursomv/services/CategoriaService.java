package com.adirenato.cursomv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adirenato.cursomv.domain.Categoria;
import com.adirenato.cursomv.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> c = repo.findById(id);
		return c.orElse(null);
	}
}
