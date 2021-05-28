package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Categoria;
import com.peretecorporate.abedsbackend.service.CategoriaService;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaRestController {

	private static final Logger	log	= LoggerFactory.getLogger(CategoriaRestController.class);

	@Autowired
	CategoriaService			categoriaService;

	@RequestMapping(value = "/allCategorias", method = RequestMethod.GET)
	List<Categoria> getAllCategorias() {

		log.info("Inicio del metodo rest CategoriaRestController>>getAllCategorias....");

		List<Categoria> categorias = categoriaService.findAllCategorias();
		log.info((categorias == null || categorias.isEmpty()) ? ("No Existen categorias") : ("Existen categorias"));

		log.info("Finaliza del metodo rest CategoriaRestController>>getAllCategorias...");

		return categorias;
	}

	@RequestMapping(value = "/{codCategoria}/", method = RequestMethod.GET)
	Categoria getCategoriaByCodCategoria(@PathVariable("codCategoria") String codCategoria) {

		log.info("Inicio del metodo rest CategoriaRestController>>getCategoriaByCodCategoria.... con parametro "
					+ codCategoria);

		Categoria categoria = categoriaService.getCategoriaByCodCategoria(codCategoria);

		log.info("Finaliza del metodo rest CategoriaRestController>>getCategoriaByCodCategoria...");

		return categoria;

	}

	@RequestMapping(value = "/nombresCategorias", method = RequestMethod.GET)
	List<String> getByNombre() {

		log.info("Inicio del metodo rest CategoriaRestController>>getByNombre....  ");

		List<String> nombreCategoriaList = categoriaService.getBynombre();

		log.info("Finaliza del metodo rest CategoriaRestController>>getByNombre...");

		return nombreCategoriaList;
	}

	@RequestMapping(value = "/codCategorias", method = RequestMethod.GET)
	List<String> getBycodCategoria() {
		log.info("Inicio del metodo rest CategoriaRestController>>getBycodCategoria....  ");

		List<String> codCategoriaList = categoriaService.getBycodCategoria();

		log.info("Finaliza del metodo rest CategoriaRestController>>getBycodCategoria...");

		return codCategoriaList;
	}

	//TODO probar.
	@RequestMapping(value = "/delete/{idCategoria}/", method = RequestMethod.DELETE)
	void deleteByIdCategoria(@PathVariable("idCategoria") Integer idCategoria) {
		log.info("Inicio del metodo rest CategoriaRestController>>deleteByIdCategoria.... con id " + idCategoria);

		categoriaService.deleteByIdCategoria(idCategoria);

		log.info("Finaliza del metodo rest CategoriaRestController>>deleteByIdCategoria...");
	}

	//TODO probar.
	@RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
	void delete(Categoria categoria) {
		log.info("Inicio del metodo rest CategoriaRestController>>delete.......");

		categoriaService.delete(categoria);

		log.info("Finaliza del metodo rest CategoriaRestController>>delete.....");
	}

	//TODO probar.
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	void save(Categoria categoria) {
		log.info("Inicio del metodo rest CategoriaRestController>>save.......");

		categoriaService.save(categoria);

		log.info("Finaliza del metodo rest CategoriaRestController>>save.....");
	}


	@RequestMapping(value = "/countNumeroCategorias", method = RequestMethod.GET)
	int countNumeroCategorias() {
		log.info("Inicio del metodo rest CategoriaRestController>>countNumeroCategorias.......");

		int contador = categoriaService.countNumeroCategorias();

		log.info("Finaliza del metodo rest CategoriaRestController>>countNumeroCategorias.....");

		return contador;
	}

}
