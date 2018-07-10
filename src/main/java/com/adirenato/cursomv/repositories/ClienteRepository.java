package com.adirenato.cursomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adirenato.cursomv.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
