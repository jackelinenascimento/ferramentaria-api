package br.com.ferramentaria.api.dto;

import br.com.ferramentaria.api.entity.Telefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDto {

	private Long idTelefone;
	private String ddd;
	private String numero;
	
	public TelefoneDto() {};
	
	public TelefoneDto(Telefone telefone) {
		this.idTelefone = telefone.getIdTelefone();
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}
	
	public static Telefone toModel(TelefoneDto telefoneDto) {
		return new Telefone(telefoneDto.getDdd(),
							telefoneDto.getNumero());
	}
}
