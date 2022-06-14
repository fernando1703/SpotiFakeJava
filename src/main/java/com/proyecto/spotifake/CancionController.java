package com.proyecto.spotifake;
                                     
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.conexion.Conexion;
import com.proyecto.entidades.Cancion;
import com.proyecto.entidades.Playlist;

@Controller
public class CancionController {
	
	boolean existeCancion = false;
	
	int usuarioId;
	
	@RequestMapping(value = "/mostrarCancion", method = RequestMethod.GET)
	public String mostrarCancion(Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		List<Playlist> listaPlaylists = new ArrayList<Playlist>();
			
		Conexion conexion = new Conexion();
		
		Cancion cancion = new Cancion();
		
		listaCanciones = cancion.listarCanciones();
		listaPlaylists = conexion.retornaListaPlaylist(usuarioId);
		
		model.addAttribute("usuarioId", usuarioId);
		model.addAttribute("listaCanciones", listaCanciones);
		model.addAttribute("listaPlaylists", listaPlaylists);
		
		conexion.liberarRecursos();
			
		return "mostrarCancion";
	}
	
	@RequestMapping(value = "/mostrarCancionAdmin", method = RequestMethod.GET)
	public String mostrarCancionAdmin(Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		
		Cancion cancion = new Cancion();
		listaCanciones = cancion.listarCanciones();
			
		model.addAttribute("listaCanciones", listaCanciones);
			
		return "mostrarCancionAdmin";
	}
	
	@RequestMapping("/formularioCancion")
	public String formularioCancion(Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Cancion cancion = new Cancion();
		
		model.addAttribute("cancion", cancion);
		model.addAttribute("existeCancion", existeCancion);
		
		return "formularioCancion";
	}
	
	@RequestMapping(value = "/guardarCancion", method = RequestMethod.POST)
	public String guardarCancion(@ModelAttribute("cancion") Cancion cancion) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		String cancionRepetida = conexion.cancionRepetida(cancion.getNombre());
		String urlRepetida = conexion.urlRepetida(cancion.getUrl());
		
		if(cancionRepetida.equals(cancion.getNombre()) || urlRepetida.equals(cancion.getUrl())) {
			return "formularioCancion";
		}
		
		cancion.agregarCancion(cancion);
			
		return "redirect:/mostrarCancionAdmin";
	}
	
	@RequestMapping(value = "editarCancion/{idCancion}")
	public String formularioEditarCancion(@PathVariable int idCancion, Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		Cancion cancion = new Cancion();
		
		cancion = conexion.obtenerCancionId(idCancion);
		
		model.addAttribute("cancion", cancion);
		
		return "formularioEditarCancion";
	}
	
	@RequestMapping(value = "/actualizarEdicion", method = RequestMethod.POST)
	public String actualizarEdicion(@ModelAttribute("cancion") Cancion cancion) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		cancion.actualizarCancion(cancion);
			
		return "redirect:/mostrarCancionAdmin";
	}
	
	@RequestMapping(value="/eliminarCancion/{idCancion}",method = RequestMethod.GET)  
	public String eliminarCancion(@PathVariable int idCancion) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Cancion cancion = new Cancion();
		cancion.eliminarCancion(idCancion);
		
		return "redirect:/mostrarCancionAdmin";
	}
	
	@RequestMapping(value = "/mostrarCancionRedirect/{idUsuario}",method = RequestMethod.GET)
	public String mostrarCancionRedirect(@PathVariable int idUsuario) {
		usuarioId = idUsuario;
		return "redirect:/mostrarCancion";
	}
	
	@RequestMapping(value = "/mostrarCancionAdminRedirect/{idUsuario}",method = RequestMethod.GET)
	public String mostrarCancionAdminRedirect(@PathVariable int idUsuario) {
		usuarioId = idUsuario;
		return "redirect:/mostrarCancionAdmin";
	}
	
	@RequestMapping("/playlistRedirect")
	public String playlistRedirect() {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		return "redirect:/mostrarListaPlaylistRedirect/" + usuarioId;
	}
	
	@RequestMapping(value = "/agregarCancionAPlaylistRedirect/{idCancion}",method = RequestMethod.GET)
	public String agregarCancionAPlaylistRedirect(@PathVariable int idCancion) {
		return "redirect:/agregarCancionAPlaylistRedirect1/" + usuarioId + "/" + idCancion;
	}
	
	@RequestMapping(value = "/logoffRedirectCancion/{idUsuario}",method = RequestMethod.GET)
	public String logoffRedirectCancion(@PathVariable int idUsuario) {
		usuarioId = idUsuario;
		return "redirect:/logoffRedirectPlaylist/" + usuarioId;
	}
	
}
