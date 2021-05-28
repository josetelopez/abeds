package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peretecorporate.abedsbackend.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer>{
	
	
	List<Equipo> findAll();

	List<Equipo> findAllByidCategoria(Integer idCategoria);
	
	List<Equipo> findAllByidEntrenador(Integer idEntrenador);
	
	List<Equipo> findAllBynombreEquipo();
	
	List<Equipo> findAllByanno();
	
	Equipo getByidEquipo(Integer idEquipo);
	
	Equipo getBynombreEquipo(String nombreEquipo);
	
	List<String> findAllNombreEquipo();
		
}
