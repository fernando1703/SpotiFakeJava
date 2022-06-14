package com.proyecto.entidades;

public class Playlist_Cancion {
	private int idPlaylist_Cancion;
	private int idPlaylist;
	private int idCancion;
	
	public Playlist_Cancion() {
		super();
	}

	public Playlist_Cancion(int idPlaylist_Cancion, int idPlaylist, int idCancion) {
		super();
		this.idPlaylist_Cancion = idPlaylist_Cancion;
		this.idPlaylist = idPlaylist;
		this.idCancion = idCancion;
	}

	public int getIdPlaylist_Cancion() {
		return idPlaylist_Cancion;
	}

	public void setIdPlaylist_Cancion(int idPlaylist_Cancion) {
		this.idPlaylist_Cancion = idPlaylist_Cancion;
	}

	public int getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}	
}
