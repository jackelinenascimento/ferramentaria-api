package br.com.ferramentaria.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.FerramentaDto;
import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.repository.FerramentaRepository;

@Service
public class FerramentaService {

	@Autowired
	private FerramentaRepository ferramentaRepository;
	
	public List<FerramentaDto> listarFerramentas(){
		List<Ferramenta> ferramentas = ferramentaRepository.findAll();
		return FerramentaDto.converter(ferramentas);
	}

	public FerramentaDto cadastrarFerramenta(FerramentaDto ferramentaDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
