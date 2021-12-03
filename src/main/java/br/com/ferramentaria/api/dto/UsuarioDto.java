package br.com.ferramentaria.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	
    private Long idUsuario;
	private LocalDateTime dataCadastro;
    private String nome;
    private String email;
	private String senha;
	private EnderecoDto endereco;
    private TelefoneDto telefone;
    private Status status;
    
    public UsuarioDto() {};
    
    public UsuarioDto(Usuario usuario) {
    	this.idUsuario = usuario.getIdUsuario();
    	this.dataCadastro = usuario.getDataCadastro();
    	this.nome = usuario.getNome();
    	this.email = usuario.getEmail();
    	this.senha = usuario.getSenha();
    	this.endereco = new EnderecoDto(usuario.getEndereco());
    	this.telefone = new TelefoneDto(usuario.getTelefone());
    	this.status = usuario.getStatus();
    }
       
	public Long getId() {
		return idUsuario;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public TelefoneDto getTelefone() {
		return telefone;
	}
	
	public Status getStatus() {
		return status;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	public static Usuario toModel(UsuarioDto usuarioDto) {
		return new Usuario(usuarioDto.getNome(),
							usuarioDto.getEmail(),
							usuarioDto.getSenha(),
							EnderecoDto.toModel(usuarioDto.getEndereco()),
							TelefoneDto.toModel(usuarioDto.getTelefone()));
		
	}

}
