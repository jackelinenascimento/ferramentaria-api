package br.com.ferramentaria.api.entity.enums;

public enum Modalidade {
	
	RESIDENCIAL("Residencial"), INDUSTRIAL("Industrial");

	private String descricao;
	
	Modalidade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
