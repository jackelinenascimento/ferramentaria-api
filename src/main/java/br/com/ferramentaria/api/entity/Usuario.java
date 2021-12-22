package br.com.ferramentaria.api.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(length=30, nullable=false, unique=false)
    private String nome;
	
	@Column(length=100, nullable=true, unique=true)
    private String email;

	@Column(nullable = true)
	private String senha;
    	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Endereco endereco;
    
	@OneToOne(cascade=CascadeType.PERSIST)
    private Telefone telefone;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
    
    public Usuario(String nome,
    			   String email,
    			   String senha,
    			   Endereco endereco,
    			   Telefone telefone,
    			   List<Perfil> perfis) {
    	
    	this.nome = nome;
    	this.email = email;
    	this.senha = senha;
    	this.endereco = endereco;
    	this.telefone = telefone;
    	this.perfis = perfis;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		if(this.status == Status.ATIVO) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(this.status == Status.ATIVO) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if(this.status == Status.ATIVO) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEnabled() {
		if(this.status == Status.ATIVO) {
			return true;
		}
		return false;
	}
}
