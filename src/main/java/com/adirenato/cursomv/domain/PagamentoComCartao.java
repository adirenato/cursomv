package com.adirenato.cursomv.domain;

import javax.persistence.Entity;

import com.adirenato.cursomv.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento est, Pedido p, Integer nroParcelas) {
		super(id, est, p);
		this.numeroDeParcelas = nroParcelas;

	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeParcelas == null) ? 0 : numeroDeParcelas.hashCode());
		return result;
	}


}
