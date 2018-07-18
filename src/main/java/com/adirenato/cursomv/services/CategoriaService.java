package com.adirenato.cursomv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.adirenato.cursomv.domain.Categoria;
import com.adirenato.cursomv.dto.CategoriaDTO;
import com.adirenato.cursomv.repositories.CategoriaRepository;
import com.adirenato.cursomv.services.exceptions.ConstraintException;
import com.adirenato.cursomv.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> c = repo.findById(id);
		// função lambda
		return c.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado " + id + ", tipo :" + CategoriaService.class.getName()));
	}

	// Utilizando o DTO para retornar somente o que é necessário
	public List<CategoriaDTO> findAll() {
		List<Categoria> list = repo.findAll();
		List<CategoriaDTO> dto = new ArrayList<>();
		list.stream().forEach(cat -> dto.add(new CategoriaDTO(cat.getId(), cat.getNome())));
		return dto;
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintException("Objeto contém filhos não pode ser deletado;");
		}
	}
}
