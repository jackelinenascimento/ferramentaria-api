package br.com.ferramentaria.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Disponibilidade;
import br.com.ferramentaria.api.entity.enums.Modalidade;
import br.com.ferramentaria.api.entity.enums.Status;
import br.com.ferramentaria.api.entity.enums.Tensao;

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
	
	public FerramentaDto() {};
	
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
	
	public Long getIdFerramenta() {
		return idFerramenta;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Tensao getTensao() {
		return tensao;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public Status getStatus() {
		return status;
	}
	
	public static Ferramenta toModel(FerramentaDto ferramentaDto) {
		return new Ferramenta(ferramentaDto.getNome(),
							  ferramentaDto.getTensao(),
							  ferramentaDto.getModalidade(),
							  ferramentaDto.getDisponibilidade(),
							  ferramentaDto.getDescricao(),
							  ferramentaDto.getProprietario());
	}

	public static List<FerramentaDto> converter(List<Ferramenta> ferramentas) {
		return ferramentas.stream().map(FerramentaDto::new).collect(Collectors.toList());
	}

}
