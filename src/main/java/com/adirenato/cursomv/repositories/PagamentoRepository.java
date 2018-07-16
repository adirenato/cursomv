package com.adirenato.cursomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adirenato.cursomv.domain.Pagamento;

// auto mapeamento da DAO

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
