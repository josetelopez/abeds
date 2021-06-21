package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.repository.IUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUsuarioRepository iUsuarioRepositorio;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = iUsuarioRepositorio.findBynombreUsuario(username).orElseThrow(
					() -> new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username));
	
		return UserDetailsImpl.build(user);
	}

}
