package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	/**
	 * Metodoo para registrar un usuario
	 * 
	 * @param usuario
	 */
	public void registrar(Usuario usuario) {
		usuarioRepository.save(usuario);

	}
}
