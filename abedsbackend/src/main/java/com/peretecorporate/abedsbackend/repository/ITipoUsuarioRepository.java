package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peretecorporate.abedsbackend.model.TipoUsuario;
/**
 * 
 * @author jlopez5
 *
 */
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

	/**
	 * Devuelve una lista de tipos de usuarios.
	 */
	List<TipoUsuario> findAll();

	/**
	 * 
	 * @param id
	 * @return
	 */
	TipoUsuario findByidTipoUsuario(Integer id);

	/**
	 * 
	 * @param tipoUsuario
	 * @return
	 */
	TipoUsuario findBytipoUsuario(String tipoUsuario);

	/**
	 * 
	 * @param codTipoUsuario
	 * @return
	 */
	TipoUsuario findByCodTipoUsuario(String codTipoUsuario);
	
	/**
	 * 
	 * @return
	 */
	@Query("Select tpusu.tipoUsuario from TipoUsuario tpusu")
	List<String> getAllBytipoUsuario();
	
	/**
	 * 
	 * @return
	 */
	@Query("Select tpusu.codTipoUsuario from TipoUsuario tpusu")
	List<String> getAllBycodTipoUsuario();

}
