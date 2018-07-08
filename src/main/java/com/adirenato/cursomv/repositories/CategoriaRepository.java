package com.adirenato.cursomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adirenato.cursomv.domain.Categoria;

// auto mapeamento da DAO

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
