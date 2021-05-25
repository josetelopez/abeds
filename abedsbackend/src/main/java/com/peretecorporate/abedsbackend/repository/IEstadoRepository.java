package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peretecorporate.abedsbackend.model.Estado;

public interface IEstadoRepository extends JpaRepository<Estado, Integer> {

	/**
	 * Devuelve todo los objetos estados que existen en la tabla abedsp_estado
	 */
	List<Estado> findAll();

	/**
	 * Devuelve un objeto estado 
	 * @param codEstado, int.
	 * @return <Estado>
	 */
	Estado getEstadoBycodEstado(int codEstado);

	/**
	 * Devuelve un objeto estado
	 * @param nombreEstado, string
	 * @return <Estado>
	 */
	Estado getEstadoBynombreEstado(String nombreEstado);

	/**
	 * Devuelve un listado de String.
	 * @return List<String>
	 */
	@Query("Select est.nombreEstado from Estado est order by codEstado")
	List<String> getnombreEstados();

}
