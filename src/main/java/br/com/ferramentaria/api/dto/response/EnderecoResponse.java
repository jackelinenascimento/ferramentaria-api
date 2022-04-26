package br.com.ferramentaria.api.dto.response;

import br.com.ferramentaria.api.entity.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoResponse {
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public EnderecoResponse(Endereco endereco) {
		
		this.logradouro = endereco.getLogradouro();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
		this.cep = endereco.getCep();
	}

}
