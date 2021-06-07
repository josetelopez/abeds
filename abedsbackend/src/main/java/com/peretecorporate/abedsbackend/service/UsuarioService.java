package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peretecorporate.abedsbackend.exception.AbedsBackendException;
import com.peretecorporate.abedsbackend.model.Usuario;

@Service
@Transactional
public interface UsuarioService {

	List<Usuario> findAll() throws AbedsBackendException;

	Usuario findUsuarioByidUsuario(Integer id) throws AbedsBackendException;

	Usuario findUsuarioByNombre(String nombre, String apellido1, String apellido2) throws AbedsBackendException;

	Usuario findUsuarioBynif(String nif) throws AbedsBackendException;

	Usuario findUsuarioByemail(String email) throws AbedsBackendException;

	List<Usuario> getListadoUsuariosAdministradores() throws AbedsBackendException;

	List<Usuario> getListadoUsuarioEntrenadores() throws AbedsBackendException;

	List<Usuario> getListadoUsuarioRespSede() throws AbedsBackendException;
	
	List<Usuario> getListadoUsuarioArbitros() throws AbedsBackendException;

	void deleteById(Integer id) throws AbedsBackendException;

	void deleteByNif(String nif) throws AbedsBackendException;

	void delete(Usuario usuario) throws AbedsBackendException;

	void save(Usuario usuario) throws AbedsBackendException;

}
