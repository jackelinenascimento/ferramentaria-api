package br.com.ferramentaria.api.entity.enums;

public enum Disponibilidade {
	
	ALUGUEL("Aluguel"), VENDA("Venda"), DOACAO("Doação");
	
	private String opcao;
	
	Disponibilidade(String opcao){
		this.opcao = opcao;
	}
	
	public String getOpcao() {
		return opcao;
	}
}
