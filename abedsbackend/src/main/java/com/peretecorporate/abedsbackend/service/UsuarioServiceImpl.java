package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findUsuarioByidUsuario(Integer id) {
		return usuarioRepository.findUsuarioByidUsuario(id);
	}

	@Override
	public Usuario findUsuarioByNombre(String nombre, String apellido1, String apellido2) {
		return usuarioRepository.findUsuarioByNombre(nombre, apellido1, apellido2);
	}

	@Override
	public Usuario findUsuarioBynif(String nif) {
		return usuarioRepository.findUsuarioBynif(nif);
	}

	@Override
	public Usuario findUsuarioByemail(String email) {
		return usuarioRepository.findUsuarioByemail(email);
	}

	@Override
	public List<Usuario> getListadoUsuariosAdministradores() {
		return usuarioRepository.getListadoUsuariosAdministradores();
	}

	@Override
	public List<Usuario> getListadoUsuarioEntrenadores() {
		return usuarioRepository.getListadoUsuarioEntrenadores();
	}

	@Override
	public List<Usuario> getListadoUsuarioRespSede() {
		return usuarioRepository.getListadoUsuarioRespSede();
	}

	@Override
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);

	}

	@Override
	public void deleteByNif(String nif) {
		usuarioRepository.deleteBynif(nif);

	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);

	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@Override
	public List<Usuario> getListadoUsuarioArbitros() {
		return usuarioRepository.getListadoUsuariosArbitros();
	}

}
