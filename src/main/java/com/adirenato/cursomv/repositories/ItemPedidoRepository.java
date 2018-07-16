package com.adirenato.cursomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adirenato.cursomv.domain.ItemPedido;

// auto mapeamento da DAO

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
