package com.erp.rh.entidade.acesso;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.erp.rh.SecurityConfig;

@Entity
public class Acesso implements Serializable, UserDetails {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200, nullable = true)
	private String usuario;
	
	@Column(length = 200, nullable = true)
	private String hashsenha;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getHashsenha() {
		return hashsenha;
	}
	
	//Nessa função vai entrar como parametro a senha aberta, o BCrypt vai trasforma em um hash e salvar no BD.
	public final void setHashsenha(String senhaAberta) {
		this.hashsenha = 
				SecurityConfig.bcryptPasswordEncoder().encode(senhaAberta);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getHashsenha();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
