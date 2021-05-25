package com.peretecorporate.abedsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abedsp_tp_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_categoria", unique = true, nullable = false)
	private Integer	idCategoria;

	@Column(name = "nombre", nullable = false, length = 50)
	private String	nombre;

	@Column(name = "cod_categoria", nullable = false, length = 50)
	private String	codCategoria;

	@Column(name = "obervacion", nullable = false, length = 250)
	private String	observacion;

	@Column(name = "orden_categoria", nullable = false, length = 1)
	private int		ordenCategoria;

	/**
	 * Getters and Setters
	 */

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getOrdenCategoria() {
		return ordenCategoria;
	}

	public void setOrdenCategoria(int ordenCategoria) {
		this.ordenCategoria = ordenCategoria;
	}

}
