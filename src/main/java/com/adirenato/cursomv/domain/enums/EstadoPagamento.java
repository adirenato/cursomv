package com.adirenato.cursomv.domain.enums;



public enum EstadoPagamento {
	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer codigo;
	private String descricao;
	
	private EstadoPagamento() {
	}
    
	private EstadoPagamento(Integer cod, String desc) {
		this.codigo = cod;
		this.descricao = desc;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public static EstadoPagamento getTipo(Integer pCodigo)
	{
		if(pCodigo == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(x.getCodigo().equals(pCodigo)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de inválido "+ pCodigo);
	}
	
}
