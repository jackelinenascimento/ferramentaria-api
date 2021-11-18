package br.com.ferramentaria.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.UsuarioDto;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDto> listaUsuarios() {
		List<Usuario> usuarios =  usuarioRepository.findAll();
		return UsuarioDto.converter(usuarios);	
	}

	public UsuarioDto cadastrarUsuario(@Valid UsuarioDto usuarioDto) {
		Usuario usuarioSalvar = UsuarioDto.toModel(usuarioDto);
		Usuario usuarioSalvo = usuarioRepository.save(usuarioSalvar);
		return new UsuarioDto(usuarioSalvo);
	}

}
