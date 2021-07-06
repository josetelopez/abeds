package com.peretecorporate.abedsbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.peretecorporate.abedsbackend.exception.AbedsBackendException;
import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.repository.IUsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger	log								= LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private IUsuarioRepository	usuarioRepository;

	private String				errorComunicaciones				= "Se ha producido un error en las comunicaciones";
	private String				noExisteUsuarioId				= "No existe el usuario con el id:";
	private String				noExisteUsuarioNombre			= "No existe el usuario con el nombre completo:";
	private String				noExisteUsuarioNif				= "No existe el usuario con el nif:";
	private String				noExisteUsuarioEmail			= "No existe el usuario con el email:";
	private String				noExisteUsuariosAdmin			= "No existen usuarios administradores";
	private String				noExisteUsuariosEntrenadores	= "No existen usuarios entrenadores";
	private String				noExisteUsuariosRespSedes		= "No existen usuarios Resp. Sede";
	private String				noExisteUsuariosArbitros		= "No existen usuario Arbitros";

	public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public UsuarioServiceImpl() {

	}

	@Override
	public List<Usuario> findAll() throws AbedsBackendException {
		try {

			if (this.usuarioRepository.findAll() != null) {
				List<Usuario> lista = new ArrayList<>();
				lista = usuarioRepository.findAll();
				return lista;
			}
			log.error("Error en el metodo findAll de UsuarioService. No se encuentra ningun usuario ");
			throw new AbedsBackendException("No existe usuarios");

		}
		catch (Exception e) {
			log.error(e.getMessage() + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public Usuario findUsuarioByidUsuario(Integer id) throws AbedsBackendException {
		try {

			if (this.usuarioRepository.findUsuarioByidUsuario(id) != null) {

				Usuario usuario = this.usuarioRepository.findUsuarioByidUsuario(id);
				return usuario;
			}

			log.error("Error en el metodo findUsuarioByidUsuario de UsuarioService. No se encuentra el usuario " + id);
			throw new AbedsBackendException(this.noExisteUsuarioId + id);

		}
		catch (Exception e) {
			log.error("Error en el metodo findUsuarioByidUsuario de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public Usuario findUsuarioByNombre(String nombre, String apellido1, String apellido2) throws AbedsBackendException {
		try {
			if (this.usuarioRepository.findUsuarioByNombre(nombre, apellido1, apellido2) != null) {
				Usuario usuario = this.usuarioRepository.findUsuarioByNombre(nombre, apellido1, apellido2);
				return usuario;
			}
			log.error("Error en el metodo findUsuarioByNombre de UsuarioService. No se encuentra el usuario " + nombre
						+ " " + apellido1 + " " + apellido2);
			throw new AbedsBackendException(this.noExisteUsuarioNombre + nombre + " " + apellido1 + " " + apellido2);
		}
		catch (Exception e) {
			log.error("Error en el metodo findUsuarioByNombre de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public Usuario findUsuarioBynif(String nif) throws AbedsBackendException {
		try {

			if (this.usuarioRepository.findUsuarioBynif(nif) != null) {
				Usuario usuario = usuarioRepository.findUsuarioBynif(nif);
				return usuario;
			}

			log.error("Error en el metodo findUsuarioBynif de UsuarioService. No se encuentra el usuario con nif"
						+ nif);
			throw new AbedsBackendException(this.noExisteUsuarioNif + nif);

		}
		catch (Exception e) {
			log.error("Error en el metodo findUsuarioBynif de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public Usuario findUsuarioByemail(String email) throws AbedsBackendException {
		try {
			if (this.usuarioRepository.findUsuarioByemail(email) != null) {
				Usuario usuario = this.usuarioRepository.findUsuarioByemail(email);
				return usuario;
			}
			log.error("Error en el metodo findUsuarioByemail de UsuarioService. No se encuentra el usuario con email"
						+ email);
			throw new AbedsBackendException(this.noExisteUsuarioEmail + email);
		}
		catch (Exception e) {
			log.error("Error en el metodo findUsuarioByemail de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public List<Usuario> getListadoUsuariosAdministradores() throws AbedsBackendException {
		try {
			if (this.usuarioRepository.getListadoUsuariosAdministradores() != null
						&& !(this.usuarioRepository.getListadoUsuariosAdministradores().isEmpty())) {

				List<Usuario> listaUsuarios = new ArrayList<>();
				listaUsuarios = this.usuarioRepository.getListadoUsuariosAdministradores();
				return listaUsuarios;
			}

			log.error("Error en el metodo getListadoUsuariosAdministradores de UsuarioService. No se encuentra ningun usuario administrador ");
			throw new AbedsBackendException(this.noExisteUsuariosAdmin);

		}
		catch (Exception e) {
			log.error("Error en el metodo getListadoUsuariosAdministradores de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public List<Usuario> getListadoUsuarioEntrenadores() throws AbedsBackendException {
		try {
			if (this.usuarioRepository.getListadoUsuarioEntrenadores() != null
						&& !(this.usuarioRepository.getListadoUsuarioEntrenadores().isEmpty())) {
				List<Usuario> listadoEntrenadores = new ArrayList<>();
				listadoEntrenadores = this.usuarioRepository.getListadoUsuarioEntrenadores();
				return listadoEntrenadores;
			}

			log.error("Error en el metodo getListadoUsuarioEntrenadores de UsuarioService. No se encuentra ningun usuario entrenador ");
			throw new AbedsBackendException(this.noExisteUsuariosEntrenadores);

		}
		catch (Exception e) {
			log.error("Error en el metodo getListadoUsuarioEntrenadores de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public List<Usuario> getListadoUsuarioRespSede() throws AbedsBackendException {

		try {
			if (this.usuarioRepository.getListadoUsuarioRespSede() != null
						&& !(this.usuarioRepository.getListadoUsuarioRespSede().isEmpty())) {

				List<Usuario> listadoRespSede = new ArrayList<>();
				listadoRespSede = this.usuarioRepository.getListadoUsuarioRespSede();
				return listadoRespSede;

			}

			log.error("Error en el metodo getListadoUsuarioRespSede de UsuarioService. No se encuentra ningun usuario Responsable de Sede ");
			throw new AbedsBackendException(this.noExisteUsuariosRespSedes);

		}
		catch (Exception e) {
			log.error("Error en el metodo getListadoUsuarioRespSede de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public List<Usuario> getListadoUsuarioArbitros() throws AbedsBackendException {
		try {
			if (this.usuarioRepository.getListadoUsuariosArbitros() != null
						&& !(this.usuarioRepository.getListadoUsuariosArbitros().isEmpty())) {
				List<Usuario> listadoArbitros = new ArrayList<>();
				listadoArbitros = usuarioRepository.getListadoUsuariosArbitros();
				return listadoArbitros;
			}
			log.error("Error en el metodo getListadoUsuarioArbitros de UsuarioService. No se encuentra ningun usuario Arbitro ");
			throw new AbedsBackendException(this.noExisteUsuariosArbitros);
		}
		catch (Exception e) {
			log.error("Error en el metodo getListadoUsuarioArbitros de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public void deleteById(Integer id) throws AbedsBackendException {
		try {
			Optional<Usuario> usuario = this.usuarioRepository.findById(id);
			if (usuario.isPresent()) {
				this.usuarioRepository.delete(usuario.get());
			}
			else {
				log.error("Error en el metodo deleteById de UsuarioService. No se encuentra el usuario: " + id);
				throw new AbedsBackendException(this.noExisteUsuarioId + id);
			}

		}
		catch (Exception e) {
			log.error("Error en el metodo deleteById de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}

	}

	@Override
	public void deleteByNif(String nif) throws AbedsBackendException {
		try {
			Usuario usuario = this.usuarioRepository.findUsuarioBynif(nif);
			if (usuario != null) {
				usuarioRepository.delete(usuario);
			}
			else {
				log.error("Error en el metodo deleteByNif de UsuarioService. No se encuentra el usuario con nif: "
							+ nif);
				throw new AbedsBackendException(this.noExisteUsuarioNif + nif);
			}

		}
		catch (Exception e) {
			log.error("Error en el metodo deleteByNif de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public void delete(Usuario usuario) throws AbedsBackendException {
		try {
			if (usuario != null) {
				usuarioRepository.delete(usuario);
			}
			else {
				log.error("Error en el metodo delete de UsuarioService. No se encuentra el objeto usuario");
				throw new AbedsBackendException(this.noExisteUsuarioId);
			}

		}
		catch (Exception e) {
			log.error("Error en el metodo delete de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}

	@Override
	public void save(Usuario usuario) throws AbedsBackendException {

		try {

			if (usuario != null && usuario.getIdUsuario() != null) {
				//update
				validateUsuario(usuario);
				usuarioRepository.save(usuario);
			}
			else if (usuario.getIdUsuario() != null) {
				//create
				validateUsuario(usuario);
				this.usuarioRepository.save(usuario);
			}
		}
		catch (Exception e) {
			log.error("Error en el metodo save de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}

	}

	/**
	 * Metodo para validar los campos del objeto usuario
	 * @param usuario
	 */
	//TODO formato de la contrasenna[], formato del nif[],
	private void validateUsuario(Usuario usuario) {
		Assert.notNull(usuario.getNombreUsuario(),
					"No se esta introduciendo nombre(alias) del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getContrasenna(),
					"No se esta introduciendo contrasenna del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getNombre(), "No se esta introduciendo nombre del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getApellido1(),
					"No se esta introduciendo apellido1 del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getApellido2(),
					"No se esta introduciendo apellido2 del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getIdDireccion(),
					"No se esta introduciendo la direccion del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getActivo(),
					"No se esta introduciendo valor al campo activo del usuario" + usuario.getIdUsuario());
		Assert.notNull(usuario.getTelefono1(),
					"No se esta introduciendo telefono1 del usuario" + usuario.getIdUsuario());

		Assert.isTrue(usuario.getNif().length() == 9, "El dni del usuario no tiene una longitud de 9 caracteres");

		Assert.isTrue(usuario.getTelefono1().length() == 9,
					"El telefono1 del usuario no tiene una longitud de 9 caracteres");
		Assert.isTrue(usuario.getTelefono2().length() == 9,
					"El telefono2 del usuario no tiene una longitud de 9 caracteres");

	}

	
	public IUsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	
	@Override
	public Optional<Usuario> findUsuarioByNombre(String nombreUsuario) throws AbedsBackendException {

		try {
			if (this.usuarioRepository.findBynombreUsuario(nombreUsuario) != null) {
				Optional<Usuario> usuario = this.usuarioRepository.findBynombreUsuario(nombreUsuario);
				return usuario;
			}

			log.error("Error en el metodo findUsuarioByNombre de UsuarioService. No se encuentra el usuario "
						+ nombreUsuario);
			throw new AbedsBackendException(this.noExisteUsuarioNombre + nombreUsuario);
		}
		catch (Exception e) {
			log.error("Error en el metodo findUsuarioByNombre de UsuarioService " + e);
			throw new AbedsBackendException(this.errorComunicaciones);
		}
	}
}
