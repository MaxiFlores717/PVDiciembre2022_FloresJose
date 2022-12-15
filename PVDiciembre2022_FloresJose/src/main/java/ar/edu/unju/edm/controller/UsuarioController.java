package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.edm.dao.IUsuarioDao;
import ar.edu.unju.edm.models.Usuario;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@RequestMapping(value = {"/listar", "/"}, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarioDao.findAll());
		return "listar";
	}
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Formulario de Usuario");
		return "form";
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model) {
		if(result.hasErrors()){
			model.addAttribute("titulo", "Formulario de Usuario");
			return "form";
		}
		else {
			usuarioDao.save(usuario);
			return "redirect:listar";
		}
	}
	@RequestMapping(value = "/form/{dni}")
	public String modificar(@PathVariable(value = "dni") Long dni, Model model) {
		Usuario usuario=null;
		usuario = usuarioDao.buscarDni(dni);
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Editar Usuario");
		
		return "form";
	}
	@RequestMapping(value = "/eliminar/{dni}")
	public String eliminar(@PathVariable(value = "dni") Long dni){
		usuarioDao.eliminar(dni);
		return "redirect:/listar";
	}
	
}
