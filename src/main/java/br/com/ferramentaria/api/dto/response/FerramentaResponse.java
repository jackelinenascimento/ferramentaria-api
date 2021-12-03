package br.com.ferramentaria.api.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.enums.Disponibilidade;
import br.com.ferramentaria.api.entity.enums.Modalidade;
import br.com.ferramentaria.api.entity.enums.Status;
import br.com.ferramentaria.api.entity.enums.Tensao;

public class FerramentaResponse {

    private Long idFerramenta;	
	private String nome;
	private String descricao;
	private Tensao tensao;
	private Modalidade modalidade;
	private Disponibilidade disponibilidade;
	private Long proprietarioId;
	private Status status;
	
	public FerramentaResponse() {};
	
	public FerramentaResponse(Ferramenta ferramenta) {
		this.idFerramenta = ferramenta.getIdFerramenta();
		this.nome = ferramenta.getNome();
		this.descricao = ferramenta.getDescricao();
		this.tensao = ferramenta.getTensao();
		this.modalidade = ferramenta.getModalidade();
		this.disponibilidade = ferramenta.getDisponibilidade();
		this.status = ferramenta.getStatus();
		this.proprietarioId = ferramenta.getProprietario().getIdUsuario();
		
	}
	
	public Long getIdFerramenta() {
		return idFerramenta;
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

	public Long getProprietarioId() {
		return proprietarioId;
	}

	public Status getStatus() {
		return status;
	}

	public static List<FerramentaResponse> converter(List<Ferramenta> ferramentas) {
		return ferramentas.stream().map(FerramentaResponse::new).collect(Collectors.toList());
	}

}
