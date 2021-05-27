package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Usuario;

@Service
public interface UsuarioService {

	List<Usuario> findAll();

	Usuario findUsuarioByidUsuario(Integer id);

	Usuario findUsuarioByNombre(String nombre, String apellido1, String apellido2);

	Usuario findUsuarioBynif(String nif);

	Usuario findUsuarioByemail(String email);

	List<Usuario> getListadoUsuariosAdministradores();

	List<Usuario> getListadoUsuarioEntrenadores();

	List<Usuario> getListadoUsuarioRespSede();
	
	List<Usuario> getListadoUsuarioArbitros();

	void deleteById(Integer id);

	void deleteByNif(String nif);

	void delete(Usuario usuario);

	void save(Usuario usuario);

}
