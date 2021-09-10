package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.TipoUsuario;
import com.peretecorporate.abedsbackend.service.TipoUsuarioService;

import io.swagger.annotations.Api;

/**
 * Controlador res para los tipos de usuario de la aplicacion abedsbackend
 * @author jlopez5
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value = "/tipoUsuario", tags = {"Operaciones con tipos de usuarios"})
@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioRestController {

	private static final Logger	log	= LoggerFactory.getLogger(TipoUsuarioRestController.class);

	/** Servicio del tipousuario */
	@Autowired
	TipoUsuarioService			tipoUsuarioService;

	/**
	 * Metodo rest que devuelve todos los tipos de usuarios de la tabla menos el tipo administrador.
	 * REQ-USUARIO-ALTA-04
	 * @return List<TipoUsuario>
	 */
	@RequestMapping(value = "/findTipoUsuarioAlta", method = RequestMethod.GET)
	public List<TipoUsuario> findTipoUsuarioAlta() {

		log.info("Inicio del metodo rest TipoUsuarioRestController>>findTipoUsuarioAlta....");

		List<TipoUsuario> tipoUsuarioList = tipoUsuarioService.findTipoUsuarioAlta();

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>findTipoUsuarioAlta...");

		return tipoUsuarioList;
	}
	
	/**
	 * Metodo rest que devuelve todos los tipos de usuarios de la tabla.
	 * @return List<TipoUsuario>
	 */
	@RequestMapping(value = "/allTipoUsuario", method = RequestMethod.GET)
	public List<TipoUsuario> getAllTipoUsuario() {

		log.info("Inicio del metodo rest TipoUsuarioRestController>>getAllTipoUsuario....");

		List<TipoUsuario> tipoUsuarioList = tipoUsuarioService.findAll();

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>getAllTipoUsuario...");

		return tipoUsuarioList;
	}
	

	/**
	 * Metodo rest que devuelve un objeto tipoUsuario, introduciendo por parametro el id.
	 * @param id (identificador del tipo de usuario)
	 * @return TipoUsuario
	 */
	@RequestMapping(value = "/findByidTipoUsuario/{id}/", method = RequestMethod.GET)
	public TipoUsuario findByidTipoUsuario(@PathVariable("id") Integer id) {

		log.info("Inicio del metodo rest TipoUsuarioRestController>>findByidTipoUsuario.... con parametro " + id);

		TipoUsuario tipoUsuario = tipoUsuarioService.findByidTipoUsuario(id);

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>findByidTipoUsuario...");

		return tipoUsuario;
	}

	/**
	 * Metodo rest que devuelve un objeto tipoUsuario, introduciendo por parametro el codTipoUsuario.
	 * @param codTipoUsuario
	 * @return <TipoUsuario>
	 */
	@RequestMapping(value = "/findByCodTipoUsuario/{codTipoUsuario}/", method = RequestMethod.GET)
	public TipoUsuario findByCodTipoUsuario(@PathVariable("codTipoUsuario") String codTipoUsuario) {

		log.info("Inicio del metodo rest TipoUsuarioRestController>>findByCodTipoUsuario.... con parametro "
					+ codTipoUsuario);

		TipoUsuario tipoUsuario = tipoUsuarioService.findByCodTipoUsuario(codTipoUsuario);

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>findByCodTipoUsuario...");

		return tipoUsuario;
	}

	/**
	 * Metodo que devuelve un listado de <String> de los nombres de tiposusuarios.
	 * @return List<String>
	 */
	@RequestMapping(value = "/getAllBytipoUsuario", method = RequestMethod.GET)
	public List<String> getAllBytipoUsuario() {

		log.info("Inicio del metodo rest TipoUsuarioRestController>>getAllBytipoUsuario.... ");

		List<String> tipoUsuarioNameList = tipoUsuarioService.getAllBytipoUsuario();

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>getAllBytipoUsuario...");

		return tipoUsuarioNameList;
	}

	/**
	 * Metodo que devuelve un listado <String> de los codigos de los tipos de usuarios
	 * @return List<String>
	 */
	@RequestMapping(value = "/getAllBycodTipoUsuario", method = RequestMethod.GET)
	public List<String> getAllBycodTipoUsuario() {

		log.info("Inicio del metodo rest TipoUsuarioRestController>>getAllBycodTipoUsuario.... ");

		List<String> codTipoUsuarioNameList = tipoUsuarioService.getAllBycodTipoUsuario();

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>getAllBycodTipoUsuario...");

		return codTipoUsuarioNameList;
	}

	/**
	 * Metodo que borra un <TipoUsuario>. Se introduce por parametro el objeto <TipoUsuario> a borrar
	 * @param <TipoUsuario>
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(TipoUsuario tipoUsuario) {
		log.info("Inicio del metodo rest TipoUsuarioRestController>>delete.... ");

		tipoUsuarioService.delete(tipoUsuario);

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>delete...");
	}

	/**
	 * Metodo que inserta un registo <TipoUsuario> en la tabla abeds_tp_usuario.
	 * @param <TipoUsuario>
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(TipoUsuario tipoUsuario) {
		log.info("Inicio del metodo rest TipoUsuarioRestController>>save.... ");

		tipoUsuarioService.save(tipoUsuario);

		log.info("Finaliza del metodo rest TipoUsuarioRestController>>save...");
	}

}
