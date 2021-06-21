package com.peretecorporate.abedsbackend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peretecorporate.abedsbackend.model.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long	serialVersionUID	= 1L;

	public static final String	ADMIN_ROL			= "ADMIN";
	public static final String	JUG_ROL				= "JUG";
	public static final String	ENT_ROL				= "ENT";
	public static final String	ARB_ROL				= "ARB";
	public static final String	RES_SEDE_ROL		= "RES_SEDE";

	private Integer				id;

	private String				username;

	private String				email;

	@JsonIgnore
	private String				password;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String username, String email, String password,
				Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Usuario user) {

		String passwordEncoding = new BCryptPasswordEncoder().encode(user.getContrasenna());

		return new UserDetailsImpl(user.getIdUsuario(), user.getNombreUsuario(), user.getEmail(), passwordEncoding,
					rolUser(user));
	}

	/**
	 * Metodo para añadir el tipo de rol
	 * @param user
	 * @return
	 */
	public static List<GrantedAuthority> rolUser(Usuario user) {
		List<GrantedAuthority> autho = new ArrayList<>();

		if (user.getIdTipoUsuario().getCodTipoUsuario().equalsIgnoreCase(ADMIN_ROL)) {
			autho.add(new SimpleGrantedAuthority(ADMIN_ROL));
		}
		else if (user.getIdTipoUsuario().getCodTipoUsuario().equalsIgnoreCase(ARB_ROL)) {
			autho.add(new SimpleGrantedAuthority(ARB_ROL));
		}
		else if (user.getIdTipoUsuario().getCodTipoUsuario().equalsIgnoreCase(JUG_ROL)) {
			autho.add(new SimpleGrantedAuthority(JUG_ROL));
		}
		else if (user.getIdTipoUsuario().getCodTipoUsuario().equalsIgnoreCase(ENT_ROL)) {
			autho.add(new SimpleGrantedAuthority(ENT_ROL));
		}
		else if (user.getIdTipoUsuario().getCodTipoUsuario().equalsIgnoreCase(RES_SEDE_ROL)) {
			autho.add(new SimpleGrantedAuthority(RES_SEDE_ROL));
		}

		return autho;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}
