package com.peretecorporate.abedsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abedsp_estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_estado", unique = true, nullable = false)
	private Integer	idEstado;

	@Column(name = "nombre_estado", nullable = false, length = 50)
	private String	nombreEstado;

	@Column(name = "cod_estado", nullable = false, length = 1)
	private int		codEstado;

	@Column(name = "observacion", nullable = false, length = 250)
	private String	observacion;
	
	
	/**
	 * Getters and Setters
	 * 
	 */
	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	

}
