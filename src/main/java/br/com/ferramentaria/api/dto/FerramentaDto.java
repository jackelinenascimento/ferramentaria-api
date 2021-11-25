package br.com.ferramentaria.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.enums.Modalidade;

public class FerramentaDto {

    private Long id;	
	private LocalDateTime dataCadastro;
    private String nome;
    private String descricao;
	private String tensao;
	private Modalidade modalidade;
	private FotoDto fotoDto;
	private UsuarioDto proprietario;
	public FerramentaDto() {};
	
	public FerramentaDto(Ferramenta ferramenta) {
		this.id = ferramenta.getId();
		this.dataCadastro = ferramenta.getDataCadastro();
		this.nome = ferramenta.getNome();
		this.descricao = ferramenta.getDescricao();
		this.tensao = ferramenta.getTensao();
		this.modalidade = ferramenta.getModalidade();
		this.fotoDto = this.foto();
		this.proprietario = new UsuarioDto();
		
	}
	private FotoDto foto() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<FerramentaDto> converter(List<Ferramenta> ferramentas) {
		// TODO Auto-generated method stub
		return null;
	}

}
