package com.peretecorporate.abedsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abedsd_equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_equipo", unique = true, nullable = false)
	private Integer		idEquipo;

	@Column(name = "nombre_equipo", nullable = false, length = 250)
	private String		nombreEquipo;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria	categoria;

	@Column(name = "anno", nullable = false, length = 4)
	private int			anno;

	@Column(name = "municipio", nullable = false, length = 250)
	private String		municipio;

	@Column(name = "activo", nullable = false, length = 1)
	private String		activo;

	@ManyToOne
	@JoinColumn(name = "id_entrenador")
	private Usuario		entrenador;

	@Column(name = "num_jugadores", nullable = false, length = 2)
	private int			numeroJugadores;

	/**
	 * Getters and Setters
	 */
	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Usuario getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Usuario entrenador) {
		this.entrenador = entrenador;
	}

	public int getNumeroJugadores() {
		return numeroJugadores;
	}

	public void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}

}
