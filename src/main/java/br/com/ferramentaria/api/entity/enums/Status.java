package br.com.ferramentaria.api.entity.enums;

public enum Status {
	
	ATIVO("Ativo"), INATIVO("Inativo");
	
	private String situacao;
	
	Status(String situacao){
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
}
