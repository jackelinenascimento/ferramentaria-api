package br.com.ferramentaria.api.dto.response;

import br.com.ferramentaria.api.entity.Telefone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelefoneResponse {
	
	private String ddd;
	private String numero;

	public TelefoneResponse(Telefone telefone) {
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
	}

}
