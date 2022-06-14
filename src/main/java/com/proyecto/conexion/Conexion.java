package com.proyecto.conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.entidades.Cancion;
import com.proyecto.entidades.Playlist;
import com.proyecto.entidades.Playlist_Cancion;
import com.proyecto.entidades.Usuario;

public class Conexion {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public Conexion() {
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=SpotiFakeSolWeb;integratedSecurity=true";
		
		try {
			DriverManager.deregisterDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			con = DriverManager.getConnection(connectionUrl);
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List retornaListaCanciones() {
		String consulta = "SELECT idCancion, nombre, artista, album, genero, fechaLanzamiento, fechaRegistro, url " + 
				"FROM Cancion order by idCancion desc";
		
		List <Cancion> listaCanciones = new ArrayList<Cancion>();
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8));
				
				listaCanciones.add(cancion);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaCanciones;
	}
	
	public String cancionRepetida(String nombre) {
		String consulta = "select top 1 nombre from Cancion where nombre = '" + nombre + "'";
		
		String cancionRepetida = "";
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				cancionRepetida = rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cancionRepetida;
	}
	
	public String urlRepetida(String url) {
		String consulta = "select top 1 url from Cancion where nombre = '" + url + "'";
		
		String urlRepetida = "";
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				urlRepetida = rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return urlRepetida;
	}
	
	public Cancion obtenerCancionId(int id) {
		
		String consulta = "select * from Cancion where idCancion = " + id;
		
		Cancion cancion = new Cancion();
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				cancion.setIdCancion(rs.getInt(1));
				cancion.setNombre(rs.getString(2));
				cancion.setArtista(rs.getString(3));
				cancion.setAlbum(rs.getString(4));
				cancion.setGenero(rs.getString(5));
				cancion.setFechaLanzamiento(rs.getDate(6));
				cancion.setFechaRegistro(rs.getDate(7));
				cancion.setUrl(rs.getString(8));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cancion;
	}
	
	public int actualizarCancion(Cancion cancion) {
		int filasAfectadas = 0;
		
		String consulta = "UPDATE Cancion set nombre = ?, artista = ?, album = ?, genero = ?, fechaLanzamiento = ?, fechaRegistro = ?, "
				+ "url = ? WHERE idCancion = ?";
		
		try {
			pstmt = con.prepareStatement(consulta);
			
			pstmt.setString(1, cancion.getNombre());
			pstmt.setString(2, cancion.getArtista());
			pstmt.setString(3, cancion.getAlbum());
			pstmt.setString(4, cancion.getGenero());
			pstmt.setDate(5, cancion.getFechaLanzamiento());
			pstmt.setDate(6, cancion.getFechaRegistro());
			pstmt.setString(7, cancion.getUrl());
			pstmt.setInt(8, cancion.getIdCancion());
			
			filasAfectadas = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public int guardarCancion(Cancion cancion) {
		int filasAfectadas = 0;
		
		String consulta = "insert into Cancion(nombre, artista, album, genero, fechaLanzamiento, fechaRegistro, url) "
				+ "values('" + cancion.getNombre() + "','" + cancion.getArtista() + "','" + cancion.getAlbum() + "','"
				+ cancion.getGenero() + "','" + cancion.getFechaLanzamiento() + "', (SELECT CAST(GETDATE() AS DATE)),'"
				+ cancion.getUrl() + "')";
		
		try {
			filasAfectadas = stmt.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public int eliminarCancion(int idCancion) {
		int filasAfectadas = 0;
		
		String consulta = "delete from Cancion where idCancion = ?";
		
		try {
			pstmt = con.prepareStatement(consulta);
			pstmt.setInt(1, idCancion);
			
			filasAfectadas = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public Date obtenerFechaActual() {
		String consulta = "select getdate()";
		
		Date fechaActual = null;
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				fechaActual = rs.getDate(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return fechaActual;
	}
	
	public List retornaListaPlaylist(int idUsuario) {
		
		String consulta = "select p.idPlaylist, p.nombre, p.fechaCreacion, p.idUsuario from Playlist p join Usuario u on u.idUsuario = p.idUsuario where u.idUsuario = " + idUsuario;
		
		List<Playlist> listaPlaylists = new ArrayList<Playlist>();
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				Playlist playlist = new Playlist(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
				listaPlaylists.add(playlist);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPlaylists;
	}
	
	public List retornaListaCancionesPlaylist(int idUsuario, int idPlaylist) {
		
		List<Cancion> listaCancionesPlaylist = new ArrayList<Cancion>();
		
		String consulta = "select c.idCancion, c.nombre, c.artista, c.album, c.genero, c.fechaLanzamiento, c.fechaRegistro, c.url " + 
				"from Cancion c join Playlist_Cancion pc on pc.idCancion = c.idCancion join Playlist p on p.idPlaylist = pc.idPlaylist " + 
				"join Usuario u on u.idUsuario = p.idUsuario " + 
				"where u.idUsuario = " + idUsuario + " and p.idPlaylist = " + idPlaylist;
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8));
				
				listaCancionesPlaylist.add(cancion);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaCancionesPlaylist;
	}
	
	public Playlist retornaPlaylist(int idPlaylist) {
		String consulta = "select idPlaylist, nombre, fechaCreacion, idUsuario from Playlist where idPlaylist = " + idPlaylist;
		Playlist playlist = new Playlist();
		
		try {
			rs = stmt.executeQuery(consulta);
			
			if(rs.next()) {
				playlist.setIdPlaylist(rs.getInt(1));
				playlist.setNombre(rs.getString(2));
				playlist.setFechaCreacion(rs.getDate(3));
				playlist.setIdUsuario(rs.getInt(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return playlist;
	}
	
	public int eliminarPlaylist(int idPlaylist) {
		int filasAfectadas = 0;
		
		String consulta = "delete from Playlist where idPlaylist = ?";
		
		try {
			pstmt = con.prepareStatement(consulta);
			pstmt.setInt(1, idPlaylist);
			
			filasAfectadas = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public int guardarPlaylist(Playlist playlist) {
		int filasAfectadas = 0;
		
		String consulta = "insert into Playlist(nombre, fechaCreacion, idUsuario) "
				+ "values('" + playlist.getNombre() + "', (SELECT CAST(GETDATE() AS DATE)), "
				+ playlist.getIdUsuario() + ")";
		
		try {
			filasAfectadas = stmt.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public Playlist_Cancion verificarCancionesRepetidasPlaylist(Playlist_Cancion playlistCancion) {
		String consulta = "select top 1 idPlaylist_Cancion, idPlaylist, idCancion from Playlist_Cancion "
				+ "where idPlaylist = " + playlistCancion.getIdPlaylist() + " and idCancion = " + playlistCancion.getIdCancion();
		
		Playlist_Cancion playlist_Cancion1 = new Playlist_Cancion();
		
		try {
			rs = stmt.executeQuery(consulta);
			
			if(rs.next()) {
				playlist_Cancion1.setIdPlaylist_Cancion(rs.getInt(1));
				playlist_Cancion1.setIdPlaylist(rs.getInt(2));
				playlist_Cancion1.setIdCancion(rs.getInt(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return playlist_Cancion1;
	}
	
	public int agregarCancionAPlaylist(Playlist_Cancion playlistCancion) {
		int filasAfectadas = 0;
		
		String consulta = "insert into Playlist_Cancion(idPlaylist, idCancion) "
				+ "values(" + playlistCancion.getIdPlaylist() + ", " + playlistCancion.getIdCancion() + ")";
		
		try {
			filasAfectadas = stmt.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public int eliminarCancionPlaylist(int idPlaylist, int idCancion) {
		int filasAfectadas = 0;
		
		String consulta = "delete from Playlist_Cancion where idPlaylist = ? and idCancion = ?";
		
		try {
			pstmt = con.prepareStatement(consulta);
			pstmt.setInt(1, idPlaylist);
			pstmt.setInt(2, idCancion);
			
			filasAfectadas = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public Usuario verificarUsuario(Usuario usuario) {
		String consulta = "SELECT top 1 correoElectronico, contraseña, rol, nombres, apellidos, idUsuario from Usuario "
				+ "where correoElectronico = '" + usuario.getCorreoElectronico() + "' and contraseña = '" + usuario.getContraseña() + "'";
		
		Usuario usuario1 = new Usuario();
		
		try {
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				usuario1.setCorreoElectronico(rs.getString(1));
				usuario1.setContraseña(rs.getString(2));
				usuario1.setRol(rs.getString(3));
				usuario1.setNombres(rs.getString(4));
				usuario1.setApellidos(rs.getString(5));
				usuario1.setIdUsuario(rs.getInt(6));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario1;
	}
	
	public int guardarUsuario(Usuario usuario) {
		int filasAfectadas = 0;
		
		String sql = "insert into Usuario(nombres, apellidos, correoElectronico, contraseña, rol, fechaCreacion) "
				+ "values('" + usuario.getNombres() + "','" + usuario.getApellidos() + "','" + usuario.getCorreoElectronico() 
				+ "','" + usuario.getContraseña() + "','" + usuario.getRol() + "', (SELECT CAST(GETDATE() AS DATE)))";
		
		try {
			filasAfectadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public int editarPlaylist(Playlist playlist) {
		int filasAfectadas = 0;
		
		String consulta = "UPDATE Playlist set idPlaylist = ?, nombre = ?, fechaCreacion = ?, idUsuario = ? "
				+ "WHERE idPlaylist = ?";
		
		try {
			pstmt = con.prepareStatement(consulta);
			
			pstmt.setInt(1, playlist.getIdPlaylist());
			pstmt.setString(2, playlist.getNombre());
			pstmt.setDate(3, playlist.getFechaCreacion());
			pstmt.setInt(4, playlist.getIdUsuario());
			pstmt.setInt(5, playlist.getIdPlaylist());
			
			filasAfectadas = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasAfectadas;
	}
	
	public void liberarRecursos() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
