package br.com.ferramentaria.api.dto;

import br.com.ferramentaria.api.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
	
    private Long enderecoId;
	private String logradouro;
    private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
    
    public EnderecoDto() {};
    
    public EnderecoDto(Endereco endereco) {
    	this.enderecoId = endereco.getEnderecoId();
    	this.logradouro = endereco.getLogradouro();
    	this.complemento = endereco.getComplemento();
    	this.bairro = endereco.getBairro();
    	this.cidade = endereco.getCidade();
    	this.uf = endereco.getUf();
    	this.cep = endereco.getCep();
    }
       
	public Long getId() {
		return enderecoId;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}
	
	public static Endereco toModel(EnderecoDto enderecoDto) {
		return new Endereco(enderecoDto.getLogradouro(),
							enderecoDto.getComplemento(),
							enderecoDto.getBairro(),
							enderecoDto.getCidade(),
							enderecoDto.getUf(),
							enderecoDto.getCep());
		
	}

}
