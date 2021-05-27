package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioRestController {

	private static final Logger	log	= LoggerFactory.getLogger(UsuarioRestController.class);

	/** Servicio usuario */
	@Autowired
	UsuarioService				usuarioService;

	@RequestMapping(value = "/allUsuario", method = RequestMethod.GET)
	public List<Usuario> findAll() {
		log.info("Inicio del metodo rest UsuarioRestController>>getAllTipoUsuario....");

		List<Usuario> usuarioList = usuarioService.findAll();

		log.info("Finaliza del metodo rest UsuarioRestController>>getAllTipoUsuario...");

		return usuarioList;
	}

	@RequestMapping(value = "/findUsuarioByid/{id}", method = RequestMethod.GET)
	public Usuario findUsuarioByid(@PathVariable("id") Integer id) {
		log.info("Inicio del metodo rest UsuarioRestController>>findUsuarioByid....");

		Usuario usuario = usuarioService.findUsuarioByidUsuario(id);

		log.info("Finaliza del metodo rest UsuarioRestController>>findUsuarioByid...");

		return usuario;
	}

	@RequestMapping(value = "/findUsuarioByNombre/{nombre}/{apellido1}/{apellido2}", method = RequestMethod.GET)
	public Usuario findUsuarioByNombre(@PathVariable("nombre") String nombre,
				@PathVariable("apellido1") String apellido1, @PathVariable("apellido2") String apellido2) {

		log.info("Inicio del metodo rest UsuarioRestController>>findUsuarioByNombre....");

		Usuario usuario = usuarioService.findUsuarioByNombre(nombre, apellido1, apellido2);

		log.info("Finaliza del metodo rest UsuarioRestController>>findUsuarioByNombre...");

		return usuario;
	}

	@RequestMapping(value = "/findUsuarioBynif/{nif}", method = RequestMethod.GET)
	public Usuario findUsuarioBynif(@PathVariable("nif") String nif) {

		log.info("Inicio del metodo rest UsuarioRestController>>findUsuarioBynif....");

		Usuario usuario = usuarioService.findUsuarioBynif(nif);

		log.info("Finaliza del metodo rest UsuarioRestController>>findUsuarioBynif...");

		return usuario;
	}

	@RequestMapping(value = "/findUsuarioByemail/{email}", method = RequestMethod.GET)
	public Usuario findUsuarioByemail(@PathVariable("email") String email) {
		log.info("Inicio del metodo rest UsuarioRestController>>findUsuarioByemail....");

		Usuario usuario = usuarioService.findUsuarioByemail(email);

		log.info("Finaliza del metodo rest UsuarioRestController>>findUsuarioByemail...");

		return usuario;
	}

	@RequestMapping(value = "/allAdministradores", method = RequestMethod.GET)
	public List<Usuario> getListadoUsuariosAdministradores() {
		log.info("Inicio del metodo rest UsuarioRestController>>getListadoUsuariosAdministradores....");
		List<Usuario> userAdmList = usuarioService.getListadoUsuariosAdministradores();
		log.info("Finaliza del metodo rest UsuarioRestController>>getListadoUsuariosAdministradores...");
		return userAdmList;
	}

	@RequestMapping(value = "/allEntrenadores", method = RequestMethod.GET)
	public List<Usuario> getListadoUsuarioEntrenadores() {
		log.info("Inicio del metodo rest UsuarioRestController>>getListadoUsuarioEntrenadores....");
		List<Usuario> userEntrenadoresList = usuarioService.getListadoUsuarioEntrenadores();
		log.info("Finaliza del metodo rest UsuarioRestController>>getListadoUsuarioEntrenadores...");
		return userEntrenadoresList;
	}

	@RequestMapping(value = "/allRespSede", method = RequestMethod.GET)
	public List<Usuario> getListadoUsuarioRespSede() {
		log.info("Inicio del metodo rest UsuarioRestController>>getListadoUsuarioRespSede....");
		List<Usuario> userRespSede = usuarioService.getListadoUsuarioRespSede();
		log.info("Finaliza del metodo rest UsuarioRestController>>getListadoUsuarioRespSede...");
		return userRespSede;
	}
	
	@RequestMapping(value = "/allArbitros", method = RequestMethod.GET)
	public List<Usuario> getListadoUsuarioArbitros() {
		log.info("Inicio del metodo rest UsuarioRestController>>getListadoUsuarioArbitros....");
		List<Usuario> userArbitros = usuarioService.getListadoUsuarioArbitros();
		log.info("Finaliza del metodo rest UsuarioRestController>>getListadoUsuarioArbitros...");
		return userArbitros;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void delete(@PathVariable("id")Integer id) {
		log.info("Inicio del metodo rest UsuarioRestController>>delete....");
		usuarioService.deleteById(id);
		log.info("Finaliza del metodo rest UsuarioRestController>>delete...");
	}

	@RequestMapping(value = "/deleteByNif/{nif}", method = RequestMethod.POST)
	public void delete(@PathVariable("nif") String nif) {
		log.info("Inicio del metodo rest UsuarioRestController>>delete....");
		usuarioService.deleteByNif(nif);
		log.info("Finaliza del metodo rest UsuarioRestController>>delete...");
		

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(Usuario usuario) {
		log.info("Inicio del metodo rest UsuarioRestController>>delete....");
		usuarioService.delete(usuario);
		log.info("Finaliza del metodo rest UsuarioRestController>>delete...");

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(Usuario usuario) {
		log.info("Inicio del metodo rest UsuarioRestController>>save....");
		usuarioService.save(usuario);
		log.info("Finaliza del metodo rest UsuarioRestController>>save...");

	}
}
