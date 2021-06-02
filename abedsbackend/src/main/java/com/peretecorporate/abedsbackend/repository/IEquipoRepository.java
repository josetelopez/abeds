package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peretecorporate.abedsbackend.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer>{
	
	
	List<Equipo> findAll();

	List<Equipo> findAllBycategoria(Integer idCategoria);
	
	List<Equipo> findAllByentrenador(Integer idEntrenador);
	
	@Query("Select equi from Equipo equi where equi.nombreEquipo = :nombreEquipo")
	List<Equipo> findAllBynombreEquipo(String nombreEquipo);
	
	List<Equipo> findAllByanno(int anno);
	
	Equipo getByidEquipo(Integer idEquipo);
	
	Equipo getBynombreEquipo(String nombreEquipo);
	
	//List<String> findAllombreEquipo();
		
}
