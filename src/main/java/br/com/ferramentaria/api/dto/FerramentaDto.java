package br.com.ferramentaria.api.dto;

import java.time.LocalDateTime;

import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Disponibilidade;
import br.com.ferramentaria.api.entity.enums.Modalidade;
import br.com.ferramentaria.api.entity.enums.Status;
import br.com.ferramentaria.api.entity.enums.Tensao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FerramentaDto {

    private Long idFerramenta;	
	private LocalDateTime dataCadastro;
	private String nome;
	private String descricao;
	private Tensao tensao;
	private Modalidade modalidade;
	private Disponibilidade disponibilidade;
	private Usuario proprietario;
	private Status status;
	
	public FerramentaDto(Ferramenta ferramenta) {
		this.idFerramenta = ferramenta.getIdFerramenta();
		this.dataCadastro = ferramenta.getDataCadastro();
		this.nome = ferramenta.getNome();
		this.descricao = ferramenta.getDescricao();
		this.tensao = ferramenta.getTensao();
		this.modalidade = ferramenta.getModalidade();
		this.disponibilidade = ferramenta.getDisponibilidade();
		this.status = ferramenta.getStatus();
		this.proprietario = ferramenta.getProprietario();	
	}
	
	public static Ferramenta toModel(FerramentaDto ferramentaDto) {
		return new Ferramenta(ferramentaDto.getNome(),
							  ferramentaDto.getTensao(),
							  ferramentaDto.getModalidade(),
							  ferramentaDto.getDisponibilidade(),
							  ferramentaDto.getDescricao(),
							  ferramentaDto.getProprietario());
	}

}
