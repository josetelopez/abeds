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
@Table(name = "abedsd_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Integer		idUsuario;

	@ManyToOne
	@JoinColumn(name = "id_tp_usuario")
	private TipoUsuario	idTipoUsuario;

	@Column(name = "nombre_usuario", length = 150, nullable = false)
	private String		nombreUsuario;

	@Column(name = "contrasenna", nullable = false)
	private String		contrasenna;

	@Column(name = "nombre", nullable = false, length = 50)
	private String		nombre;

	@Column(name = "apellido1", nullable = false, length = 50)
	private String		apellido1;

	@Column(name = "apellido2", nullable = false, length = 50)
	private String		apellido2;

	@Column(name = "nif", length = 9)
	private String		nif;

	@ManyToOne
	@JoinColumn(name = "id_direccion")
	private Direccion	idDireccion;

	@Column(name = "activo", nullable = false, length = 1)
	private String		activo;

	@Column(name = "telefono1", nullable = false, length = 12)
	private String		telefono1;

	@Column(name = "telefono2", length = 12)
	private String		telefono2;

	@Column(name = "email", length = 250)
	private String		email;

	/**
	 * Constructores
	 */

	public Usuario() {

	}

	public Usuario(String nombreUsuario, String email, String contrasenna) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenna = contrasenna;
	}

	/**
	 * Getter y setter
	 * 
	 */

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public TipoUsuario getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setIdDireccion(Direccion idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Direccion getIdDireccion() {
		return idDireccion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
