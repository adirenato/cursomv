package com.adirenato.cursomv.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer id;
	private String nome;

	private TipoCliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public Integer getTipo() {
		return this.id;
	}

	public static TipoCliente getEnum(Integer pId) {
		if (pId == null)
			return null;
		for (TipoCliente x : TipoCliente.values()) {
			if (x.getTipo().equals(pId))
				return x;
		}
		throw new IllegalArgumentException("Id inválido" + pId);
	}

}
