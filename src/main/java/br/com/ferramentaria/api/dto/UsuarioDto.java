package br.com.ferramentaria.api.dto;

import br.com.ferramentaria.api.entity.Endereco;
import br.com.ferramentaria.api.entity.Telefone;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
    private String nome;
    private String email;	
	private String senha;
	private Endereco endereco;
    private Telefone telefone;
    private Status status;
    
    public UsuarioDto(Usuario usuario) {
    	this.nome = usuario.getNome();
    	this.email = usuario.getEmail();
    	this.senha = usuario.getSenha();
    	this.endereco = usuario.getEndereco();
    	this.telefone = usuario.getTelefone();
    	this.status = usuario.getStatus();
    }

	public static Usuario toModel(UsuarioDto usuarioDto) {
		return new Usuario(usuarioDto.getNome(),
							usuarioDto.getEmail(),
							usuarioDto.getSenha(),
							usuarioDto.getEndereco(),
							usuarioDto.getTelefone());
	}
}
