package com.peretecorporate.abedsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abedsp_tp_usuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_tp_usuario", unique = true, nullable = false)
	private Integer	idTipoUsuario;

	@Column(name = "tipo_usuario", length = 100, nullable = false)
	private String	tipoUsuario;

	@Column(name = "cod_tipo_usuario", length = 10, nullable = false)
	private String	codTipoUsuario;

	@Column(name = "descripcion", length = 100)
	private String	descripcion;

	@Column(name = "lg_activo", length = 100)
	private String	lgActivo;

	/**
	 * Getters and Setters
	 */

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCodTipoUsuario() {
		return codTipoUsuario;
	}

	public void setCodTipoUsuario(String codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLgActivo() {
		return lgActivo;
	}

	public void setLgActivo(String lgActivo) {
		this.lgActivo = lgActivo;
	}

}
