package com.proyecto.entidades;

import java.sql.Date;

public class CancionesEscuchadas {
	private int idCancionesEscuchadas;
	private Date fecha;
	private int idUsuario;
	private int idCancion;
	
	public CancionesEscuchadas() {
		super();
	}

	public CancionesEscuchadas(int idCancionesEscuchadas, Date fecha, int idUsuario, int idCancion) {
		super();
		this.idCancionesEscuchadas = idCancionesEscuchadas;
		this.fecha = fecha;
		this.idUsuario = idUsuario;
		this.idCancion = idCancion;
	}

	public int getIdCancionesEscuchadas() {
		return idCancionesEscuchadas;
	}

	public void setIdCancionesEscuchadas(int idCancionesEscuchadas) {
		this.idCancionesEscuchadas = idCancionesEscuchadas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}
	
	
	
}
