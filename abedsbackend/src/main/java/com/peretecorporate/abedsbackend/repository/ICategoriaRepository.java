package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.peretecorporate.abedsbackend.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

	/**
	 * Devuelve un listado de todas las categorias que estan activas y ordenadas ascendentemente por orden de convocatoria.
	 * @return List<Categoria> categorias.
	 */
	@Query("Select cat from Categoria cat order by ordenCategoria")
	List<Categoria> findAllCategorias();

	/**
	 * Devuelve una categoria
	 * @param codCategoria
	 * @return Categoria
	 */
	Categoria getCategoriaBycodCategoria(String codCategoria);

	/**
	 * Devuelve un listado de los nombres de la categorias
	 * @return List<String>
	 */
	@Query("Select cat.nombre from Categoria cat order by ordenCategoria")
	List<String> getBynombre();

	/**
	 * Devuelve un listado de los codigos de las categorias
	 * @return List<String>
	 */
	@Query("Select cat.codCategoria from Categoria cat order by ordenCategoria")
	List<String> findBycodCategoria();

	/**
	 * Borra una categoria annadiendo por parametro el id de la categoria.
	 * @param id
	 */
	void deleteByIdCategoria(@Param("id") Integer id);

}
