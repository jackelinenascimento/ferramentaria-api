package br.com.ferramentaria.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	
    private Long id;
	private LocalDateTime dataCadastro;
    private String nome;
    private String email;
	private String senha;
	private String logradouro;
    private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
    private String telefone;
    
    public UsuarioDto() {};
    
    public UsuarioDto(Usuario usuario) {
    	this.id = usuario.getId();
    	this.dataCadastro = usuario.getDataCadastro();
    	this.nome = usuario.getNome();
    	this.email = usuario.getEmail();
    	this.senha = usuario.getSenha();
    	this.logradouro = usuario.getLogradouro();
    	this.complemento = usuario.getComplemento();
    	this.bairro = usuario.getBairro();
    	this.cidade = usuario.getCidade();
    	this.uf = usuario.getUf();
    	this.cep = usuario.getCep();
    	this.telefone = usuario.getTelefone();
    }
       
	public Long getId() {
		return id;
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

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	public static Usuario toModel(UsuarioDto usuarioDto) {
		return new Usuario(usuarioDto.getNome(),
							usuarioDto.getEmail(),
							usuarioDto.getSenha(),
							usuarioDto.getLogradouro(),
							usuarioDto.getComplemento(),
							usuarioDto.getBairro(),
							usuarioDto.getCidade(),
							usuarioDto.getUf(),
							usuarioDto.getCep(),
							usuarioDto.getTelefone());
		
	}

}
