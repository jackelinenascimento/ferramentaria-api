package br.com.ferramentaria.api.entity.enums;

public enum Tensao {

	V110("110V"), V220("220V"), NAO_APLICA("Não se aplica");

	private String valor;
	
	Tensao(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
