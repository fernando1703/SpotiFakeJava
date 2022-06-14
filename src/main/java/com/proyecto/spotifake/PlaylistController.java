package com.proyecto.spotifake;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.conexion.Conexion;
import com.proyecto.entidades.Cancion;
import com.proyecto.entidades.Playlist;
import com.proyecto.entidades.Playlist_Cancion;

@Controller
public class PlaylistController {
	
	int usuarioId;
	int cancionId;
	
	@RequestMapping(value = "/mostrarListaPlaylist", method = RequestMethod.GET)
	public String mostrarListaPlaylist(Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		List<Playlist> listaPlaylist = new ArrayList<Playlist>();
		Playlist playlist1 = new Playlist();
			
		listaPlaylist = playlist1.mostrarPlaylist(usuarioId);
			
		model.addAttribute("listaPlaylist", listaPlaylist);
		model.addAttribute("playlist", playlist1);
	
		return "mostrarListaPlaylist";
	}
	
	@RequestMapping(value = "/listaCancionesPlaylist/{idPlaylist}",method = RequestMethod.GET)
	public String listaCancionesPlaylist(@PathVariable int idPlaylist, Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		List<Cancion> listaCancionesPlaylist = new ArrayList<Cancion>();
		Playlist playlist = new Playlist();
		
		listaCancionesPlaylist = conexion.retornaListaCancionesPlaylist(usuarioId, idPlaylist);
		playlist = conexion.retornaPlaylist(idPlaylist);
		conexion.liberarRecursos();
		
		model.addAttribute("listaCancionPlaylist", listaCancionesPlaylist);
		model.addAttribute("playlist", playlist);
		
		return "listaCancionPlaylist";
	}
	
	@RequestMapping(value = "/editarPlaylist", method = RequestMethod.POST)
	public String editarPlaylist(@ModelAttribute("playlist") Playlist playlist) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		playlist.setIdUsuario(usuarioId);
		conexion.editarPlaylist(playlist);
		conexion.liberarRecursos();
			
		return "redirect:/mostrarListaPlaylist";
	}
	
	@RequestMapping(value="/eliminarPlaylist/{idPlaylist}",method = RequestMethod.GET)  
	public String eliminarPlaylist(@PathVariable int idPlaylist) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Playlist playlist = new Playlist();
		playlist.eliminarPlaylist(idPlaylist);
		
		return "redirect:/mostrarListaPlaylist";
	}
	
	@RequestMapping(value = "/guardarPlaylist", method = RequestMethod.POST)
	public String guardarPlaylist(@ModelAttribute("playlist") Playlist playlist) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		playlist.setIdUsuario(usuarioId);
		playlist.nuevaPlaylist(playlist);
			
		return "redirect:/mostrarListaPlaylist";
	}
	
	@RequestMapping(value = "/guardarPlaylistAgregarCancionPlaylist", method = RequestMethod.POST)
	public String guardarPlaylistAgregarCancionPlaylist(@ModelAttribute("playlist") Playlist playlist) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		playlist.setIdUsuario(usuarioId);
		conexion.guardarPlaylist(playlist);
		conexion.liberarRecursos();
			
		return "redirect:/seleccionarPlaylist";
	}
	
	@RequestMapping(value="/agregarCancionAPlaylistCancion/{idCancion}",method = RequestMethod.GET)  
	public String agregarCancionAPlaylistCancion(@PathVariable int idCancion) {
		
		cancionId = idCancion;
		
		return "redirect:/seleccionarPlaylist";
	}
	
	@RequestMapping(value = "/seleccionarPlaylist", method = RequestMethod.GET)
	public String seleccionarPlaylist(Model model) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		List<Playlist> listaPlaylist = new ArrayList<Playlist>();
		Playlist playlist1 = new Playlist();
		Conexion conexion = new Conexion();
		listaPlaylist = conexion.retornaListaPlaylist(usuarioId);
		
		model.addAttribute("listaPlaylist", listaPlaylist);
		model.addAttribute("playlist", playlist1);
		
		conexion.liberarRecursos();
			
		return "seleccionarPlaylist";
	}
	
	@RequestMapping(value="/cancionPlaylistAgregar/{idPlaylist}",method = RequestMethod.GET)  
	public String cancionPlaylistAgregar(@PathVariable int idPlaylist) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		Playlist_Cancion playlistCancion = new Playlist_Cancion();
		Playlist_Cancion playlistCancionConsulta = new Playlist_Cancion();
		playlistCancion.setIdPlaylist(idPlaylist);
		playlistCancion.setIdCancion(cancionId);
		playlistCancionConsulta = conexion.verificarCancionesRepetidasPlaylist(playlistCancion);
		
		if(playlistCancionConsulta.getIdPlaylist() == idPlaylist && playlistCancionConsulta.getIdCancion() == cancionId) {
			conexion.liberarRecursos();
			return "redirect:/seleccionarPlaylist";
		}
		
		conexion.agregarCancionAPlaylist(playlistCancion);		
		conexion.liberarRecursos();
		
		return "redirect:/listaCancionesPlaylist/" + idPlaylist;
	}
	
	@RequestMapping(value="/quitarCancionPlaylist/{idCancion}/{idPlaylist}",method = RequestMethod.GET)  
	public String quitarCancionPlaylist(@PathVariable int idCancion, @PathVariable int idPlaylist) {
		
		if(usuarioId == 0)
			return "redirect:/home";
		
		Conexion conexion = new Conexion();
		Playlist_Cancion playlistCancion = new Playlist_Cancion();		
		conexion.eliminarCancionPlaylist(idPlaylist, idCancion);		
		
		return "redirect:/listaCancionesPlaylist/" + idPlaylist;
	}
	
	@RequestMapping(value = "/mostrarListaPlaylistRedirect/{idUsuario}",method = RequestMethod.GET)
	public String mostrarListaPlaylistRedirect(@PathVariable int idUsuario) {
		usuarioId = idUsuario;
		return "redirect:/mostrarListaPlaylist";
	}
	
	@RequestMapping(value = "/agregarCancionAPlaylistRedirect1/{idUsuario}/{idCancion}",method = RequestMethod.GET)
	public String agregarCancionAPlaylistRedirect1(@PathVariable int idUsuario, @PathVariable int idCancion) {
		usuarioId = idUsuario;
		return "redirect:/agregarCancionAPlaylistCancion/" + idCancion;
	}
	
	@RequestMapping(value = "/logoffRedirectPlaylist/{idUsuario}",method = RequestMethod.GET)
	public String logoffRedirectPlaylist(@PathVariable int idUsuario) {
		usuarioId = idUsuario;
		return "redirect:/home";
	}
}
