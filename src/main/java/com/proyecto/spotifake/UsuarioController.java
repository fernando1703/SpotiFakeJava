package com.proyecto.spotifake;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.conexion.Conexion;
import com.proyecto.entidades.Usuario;

@Controller
public class UsuarioController {
	
	int usuarioId;
	
	@RequestMapping("/login")
	public String login(Model model) {
		
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "login";
	}
	
	@RequestMapping("/logoffRedirect")
	public String logoffRedirect() {
		
		usuarioId = 0;
		
		return "redirect:/logoffRedirectCancion/" + usuarioId;
	}
	
	@RequestMapping("/registrarUsuario")
	public String registrarUsuario(Model model) {
		
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		
		return "registrarUsuario";
	}
	
	@RequestMapping(value = "/verificarUsuarioLogin", method = RequestMethod.POST)
	public String verificarUsuarioLogin(@ModelAttribute("usuario") Usuario usuario) {
		
		Conexion conexion = new Conexion();
		Usuario usuario1 = new Usuario();
		usuario1 = conexion.verificarUsuario(usuario);
		
		if(usuario.getCorreoElectronico().equals(usuario1.getCorreoElectronico()) && usuario.getContraseña().equals(usuario1.getContraseña())) {
			if(usuario1.getRol().equals("usuario")) {
				
				conexion.liberarRecursos();
				usuarioId = usuario1.getIdUsuario();
				return "redirect:/mostrarCancionRedirect/" + usuarioId;
			}	
			if(usuario1.getRol().equals("admin")) {
				conexion.liberarRecursos();
				usuarioId = usuario1.getIdUsuario();
				return "redirect:/mostrarCancionAdminRedirect/" + usuarioId;
			}
			else
				return "login";
		}
		
		conexion.liberarRecursos();
			
		return "login";
	}
	
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST)
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		
		Conexion conexion = new Conexion();
		Usuario usuario1 = new Usuario();
		
		usuario1 = conexion.verificarUsuario(usuario);
		
		if((usuario.getNombres().equals(usuario1.getNombres()) && usuario.getApellidos().equals(usuario1.getApellidos())) ||
				(usuario.getCorreoElectronico().equals(usuario1.getCorreoElectronico()) && usuario.getContraseña().equals(usuario1.getContraseña()))){
			conexion.liberarRecursos();
			return "redirect:/registrarUsuario";
		}
	
		usuario.setRol("usuario");
		usuario.registrarUsuario(usuario);
		usuario1 = conexion.verificarUsuario(usuario);
		usuarioId = usuario1.getIdUsuario();
		conexion.liberarRecursos();
			
		return "redirect:/mostrarCancionRedirect/" + usuarioId;
	}	
}
