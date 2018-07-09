package com.adirenato.cursomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adirenato.cursomv.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
