package com.proyecto.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.conexion.Conexion;

public class Cancion {
	private int idCancion;
	private String nombre;
	private String artista;
	private String album;
	private String genero;
	private Date fechaLanzamiento;
	private Date fechaRegistro;
	private String url;
	
	public Cancion() {
		super();
	}

	public Cancion(int idCancion, String nombre, String artista, String album, String genero, Date fechaLanzamiento,
			Date fechaRegistro, String url) {
		super();
		this.idCancion = idCancion;
		this.nombre = nombre;
		this.artista = artista;
		this.album = album;
		this.genero = genero;
		this.fechaLanzamiento = fechaLanzamiento;
		this.fechaRegistro = fechaRegistro;
		this.url = url;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void agregarCancion(Cancion cancion) {
		Conexion conexion = new Conexion();
		conexion.guardarCancion(cancion);
		conexion.liberarRecursos();
	}
	
	public void actualizarCancion(Cancion cancion) {
		Conexion conexion = new Conexion();
		conexion.actualizarCancion(cancion);
	}
	
	public void eliminarCancion(int idCancion) {
		Conexion conexion = new Conexion();
		conexion.eliminarCancion(idCancion);
		conexion.liberarRecursos();
	}
	
	public List listarCanciones() {
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		
		Conexion conexion = new Conexion();
		listaCanciones = conexion.retornaListaCanciones();
		conexion.liberarRecursos();
		
		return listaCanciones;
	}
}
