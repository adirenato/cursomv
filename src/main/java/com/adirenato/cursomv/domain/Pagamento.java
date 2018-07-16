package com.adirenato.cursomv.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.adirenato.cursomv.domain.enums.EstadoPagamento;

@Entity
//duas estrategias tabelão ou cada classe herdada ter sua tabela
//nas classes filhas não precisa fazer nada pois o db já identifica a herança 
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;

	// mesmo id do pedido (um pra um )
	@OneToOne
	@JoinColumn(name = "pedido_id") // nome que irá gerar na coluna
	@MapsId // garante o mesmo id
	private Pedido pedido;

	private Integer estado;

	//private List<Produto> produtos = new ArrayList<>();

	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento est, Pedido p) {
		this.id = id;
		this.estado = est.getCodigo();
		this.pedido = p;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.getTipo(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCodigo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



}
