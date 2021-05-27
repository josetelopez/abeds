package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peretecorporate.abedsbackend.model.Direccion;

public interface IDireccionRepository extends JpaRepository<Direccion, Integer> {
	
	
	List<Direccion> findAll();
	
	List<Direccion> findAllBycodPostal(int codPostal);
	
	List<Direccion> findBymunicipio(String municipio);
	
	Direccion findByidDireccion(Integer id);
	
	@Query("Select dir from Direccion dir inner join Usuario usu on usu.idDireccion = dir.idDireccion where usu.idUsuario = :idUsuario")
	Direccion findByidUsuario(Integer idUsuario);
	
	@Query("Select distinct dir.municipio from Direccion dir")
	List<String> findAllBymunicipio();
	
}
