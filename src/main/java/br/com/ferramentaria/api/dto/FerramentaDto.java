package br.com.ferramentaria.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Disponibilidade;
import br.com.ferramentaria.api.entity.enums.Modalidade;
import br.com.ferramentaria.api.entity.enums.Status;
import br.com.ferramentaria.api.entity.enums.Tensao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FerramentaDto {

	private LocalDateTime dataCadastro;
	
	@NotEmpty
	private String nome;
	
	private String descricao;
	
	@NotNull
	private Tensao tensao;
	
	@NotNull
	private Modalidade modalidade;
	
	@NotNull
	private Disponibilidade disponibilidade;
	
	@NotNull
	private Long proprietarioId;
	
	private Usuario proprietario;
	
	private Status status;
			
	public static Ferramenta toModel(FerramentaDto ferramentaDto) {
		return new Ferramenta(ferramentaDto.getNome(),
							  ferramentaDto.getTensao(),
							  ferramentaDto.getModalidade(),
							  ferramentaDto.getDisponibilidade(),
							  ferramentaDto.getDescricao(),
							  ferramentaDto.getProprietario());
	}

}
