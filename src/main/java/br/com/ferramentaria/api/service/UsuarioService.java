package br.com.ferramentaria.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.UsuarioDto;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.dto.response.UsuarioResponse;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.exceptions.UsuarioNaoEncontrado;
import br.com.ferramentaria.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioResponse> listaUsuarios() {
		List<Usuario> usuarios =  usuarioRepository.findAll();
		return UsuarioResponse.converter(usuarios);	
	}

	public UsuarioResponse pesquisarPorId(Long id) throws UsuarioNaoEncontrado {
		Usuario usuario = verificaSeExistePorId(id);
		return new UsuarioResponse(usuario);
	}

	public UsuarioResponse pesquisarPorEmail(String email) throws UsuarioNaoEncontrado {
		Usuario usuario = verificaSeExistePorEmail(email);
		return new UsuarioResponse(usuario);
	}

	public MessageResponseDto cadastrarUsuario(@Valid UsuarioDto usuarioDto) {
		Usuario usuarioSalvo = usuarioRepository.save(UsuarioDto.toModel(usuarioDto));
		
		MessageResponseDto messageResponse = criarMensagemResposta("Usuario criado - ID: ", usuarioSalvo.getIdUsuario());
		return messageResponse;
	}	

	public Usuario verificaSeExistePorId(Long id) throws UsuarioNaoEncontrado {
		return usuarioRepository.findById(id).orElseThrow(() ->
			new UsuarioNaoEncontrado(id));
	}

	private Usuario verificaSeExistePorEmail(String email) throws UsuarioNaoEncontrado {
		return usuarioRepository.findByEmail(email).orElseThrow(() ->
			new UsuarioNaoEncontrado(email));
	}
	
	private MessageResponseDto criarMensagemResposta(String s, Long id) {
		return MessageResponseDto.message(s + id);
	}

}
