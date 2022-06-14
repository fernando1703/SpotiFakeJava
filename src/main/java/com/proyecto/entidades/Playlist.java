package com.proyecto.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.conexion.Conexion;

public class Playlist {
	private int idPlaylist;
	private String nombre;
	private Date fechaCreacion;
	private int idUsuario;
	
	public Playlist() {
		super();
	}

	public Playlist(int idPlaylist, String nombre, Date fechaCreacion, int idUsuario) {
		super();
		this.idPlaylist = idPlaylist;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.idUsuario = idUsuario;
	}

	public int getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void nuevaPlaylist(Playlist playlist) {
		Conexion conexion = new Conexion();
		conexion.guardarPlaylist(playlist);
		conexion.liberarRecursos();
	}
	
	public void eliminarPlaylist(int idPlaylist) {
		Conexion conexion = new Conexion();
		conexion.eliminarPlaylist(idPlaylist);
		conexion.liberarRecursos();
	}
	
	public List mostrarPlaylist(int usuarioId) {
		List<Playlist> listaPlaylist = new ArrayList<Playlist>();
		Conexion conexion = new Conexion();
		listaPlaylist = conexion.retornaListaPlaylist(usuarioId);
		conexion.liberarRecursos();
		return listaPlaylist;
	}
}
