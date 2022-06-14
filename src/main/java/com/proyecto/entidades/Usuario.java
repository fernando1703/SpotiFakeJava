package com.proyecto.entidades;

import java.sql.Date;

import com.proyecto.conexion.Conexion;

public class Usuario {
	private int idUsuario;
	private String nombres;
	private String apellidos;
	private String correoElectronico;
	private String contrase�a;
	private String rol;
	private Date fechaCreacion;
	
	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nombres, String apellidos, String correoElectronico, String contrase�a,
			String rol, Date fechaCreacion) {
		super();
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.contrase�a = contrase�a;
		this.rol = rol;
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public void registrarUsuario(Usuario usuario) {
		Conexion conexion = new Conexion();
		conexion.guardarUsuario(usuario);
	}
	
}
