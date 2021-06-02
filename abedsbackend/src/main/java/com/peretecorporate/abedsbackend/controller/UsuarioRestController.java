package com.peretecorporate.abedsbackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuario")
@Api(value = "/usuario", tags = { "Operaciones con usuarios" })
public class UsuarioRestController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioRestController.class);

	/** Servicio usuario */
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/allUsuario", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener listado usuarios", notes = "Este metodo obtiene un listado de todos los usuarios")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado") })
	public ResponseEntity<List<Usuario>> findAll() {
		log.info("REST Solicitud GET de /usuario/allUsuario para obtener listado de usuarios.");

		List<Usuario> usuarioList = usuarioService.findAll();

		if (!usuarioList.isEmpty()) {
			log.info("REST Respuesta GET de /usuario/allUsuario  para obtener listado de usuarios. " + HttpStatus.OK);
			return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/allUsuario  para obtener listado de usuarios. "
				+ HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/findUsuarioByid/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener usuario", notes = "Este metodo obtiene un usuario por su id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado") })
	public ResponseEntity<Usuario> findUsuarioByid(
			@ApiParam(value = "id de usuario del usuario que vamos a buscar", required = true) @PathVariable("id") Integer id) {
		log.info("REST Solicitud GET de /usuario/findUsuarioByid/{id} para obtener usuario por id " + id);

		Usuario usuario = usuarioService.findUsuarioByidUsuario(id);
		if (usuario != null) {
			log.info("REST Respuesta GET de /usuario/findUsuarioByid/{id}  para obtener usuario por id . " + id + " "
					+ HttpStatus.OK);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}

		log.info("REST Respuesta GET de /usuario/findUsuarioByid/{id}  para obtener usuario por id . " + id + " "
				+ HttpStatus.NO_CONTENT);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/findUsuarioByNombre/{nombre}/{apellido1}/{apellido2}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener usuario por nombre - apellido1 - apellido2", notes = "Este metodo obtiene un usuario por su nombre completo")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "No esta autorizado para realizar esta operacion"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "No se ha encontrado") })
	public Usuario findUsuarioByNombre(
			@ApiParam(value = "nombre del usuario que vamos a buscar", required = true) @PathVariable("nombre") String nombre,
			@ApiParam(value = "apellido1 de usuario del usuario que vamos a buscar", required = true) @PathVariable("apellido1") String apellido1,
			@ApiParam(value = "apellido2 de usuario del usuario que vamos a buscar", required = true) @PathVariable("apellido2") String apellido2) {

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
	public void delete(@PathVariable("id") Integer id) {
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
