package br.com.ferramentaria.api.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder encoder;

	public Page<UsuarioResponse> listaUsuarios(int pagina, int qtd) {
		
		Pageable paginacao = PageRequest.of(pagina, qtd);
		Page<Usuario> usuarios =  usuarioRepository.findAll(paginacao);
		
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

	public MessageResponseDto cadastrarUsuario(@Valid UsuarioDto usuarioDto){
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDto.getEmail());
		
		if(usuario.isPresent()) {
			throw new IllegalArgumentException("E-mail já cadastrado");			
		}
		
		String senhaCriptografada = encoder.encode(usuarioDto.getSenha());
		usuarioDto.setSenha(senhaCriptografada);
		
		Usuario usuarioSalvo = usuarioRepository.save(UsuarioDto.toModel(usuarioDto));
		return MessageResponseDto.message("Usuario criado - ID: " +  usuarioSalvo.getIdUsuario());
	}	
	
	public MessageResponseDto atualizarDadosUsuario(Long id, @Valid UsuarioDto usuarioDto) throws UsuarioNaoEncontrado {
		
		verificaSeExistePorEmail(usuarioDto.getEmail());
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDto.getEmail());
		
		Usuario usuarioAtualizado = usuario.get();
		
		if(!usuarioAtualizado.getNome().equals(usuarioDto.getNome()) || !usuarioDto.getNome().isEmpty()) {
			usuarioAtualizado.setNome(usuarioDto.getNome());
		}
		
		if(!usuarioAtualizado.getSenha().equals(usuarioDto.getSenha()) || !usuarioDto.getSenha().isEmpty()){
			usuarioAtualizado.setSenha(usuarioDto.getSenha());
		}
		
		if(!usuarioAtualizado.getEndereco().getLogradouro().equals(usuarioDto.getEndereco().getLogradouro())) {
			usuarioAtualizado.getEndereco().setLogradouro(usuarioDto.getEndereco().getLogradouro());	
		}
		
		if(!usuarioAtualizado.getEndereco().getComplemento().equals(usuarioDto.getEndereco().getComplemento())) {
			usuarioAtualizado.getEndereco().setLogradouro(usuarioDto.getEndereco().getComplemento());
		}
		
		if(!usuarioAtualizado.getEndereco().getBairro().equals(usuarioDto.getEndereco().getBairro())) {
			usuarioAtualizado.getEndereco().setBairro(usuarioDto.getEndereco().getBairro());
		}
		
		if(!usuarioAtualizado.getEndereco().getCidade().equals(usuarioDto.getEndereco().getCidade())) {
			usuarioAtualizado.getEndereco().setCidade(usuarioDto.getEndereco().getCidade());
		}
		
		if(!usuarioAtualizado.getEndereco().getUf().equals(usuarioDto.getEndereco().getUf())) {
			usuarioAtualizado.getEndereco().setUf(usuarioDto.getEndereco().getUf());
		}
		
		if(!usuarioAtualizado.getEndereco().getCep().equals(usuarioDto.getEndereco().getCep())) {
			usuarioAtualizado.getEndereco().setCep(usuarioDto.getEndereco().getCep());
		}
		
		if(!usuarioAtualizado.getTelefone().getDdd().equals(usuarioDto.getTelefone().getDdd())) {
			usuarioAtualizado.getTelefone().setDdd(usuarioDto.getTelefone().getDdd());
		}
	
		if(!usuarioAtualizado.getTelefone().getNumero().equals(usuarioDto.getTelefone().getNumero())) {
			usuarioAtualizado.getTelefone().setNumero(usuarioDto.getTelefone().getNumero());
		}
		
		usuarioRepository.save(usuarioAtualizado);
		
		return MessageResponseDto.message("Usuario atualizado - ID: " + usuarioAtualizado.getIdUsuario());
	}

	public Usuario verificaSeExistePorId(Long id) throws UsuarioNaoEncontrado {
		return usuarioRepository.findById(id).orElseThrow(() ->
			new UsuarioNaoEncontrado(id));
	}

	private Usuario verificaSeExistePorEmail(String email) throws UsuarioNaoEncontrado {
		return usuarioRepository.findByEmail(email).orElseThrow(() ->
			new UsuarioNaoEncontrado(email));
	}
}
