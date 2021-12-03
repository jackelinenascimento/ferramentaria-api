package br.com.ferramentaria.api.dto;

import br.com.ferramentaria.api.entity.Foto;

public class FotoDto {
	
	private Long idFoto;
	private String caminho;
		
	public FotoDto() {};
	
	public FotoDto(String caminho) {
		this.caminho = caminho;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public String getCaminho() {
		return caminho;
	}
	
	public static Foto toModel(FotoDto fotoDto) {
		return new Foto();
	}

}
