package ar.edu.unju.edm.controller;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	
	@GetMapping(value = {"/login", "/logout"})
	public String login(Model model, Principal principal, RedirectAttributes flash) {
		if(principal != null) {
//			flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");//no funciona
			flash.addFlashAttribute("message", "Account created!");
			return "redirect:/";
			
		}
		
		return "login";
	}
	
	
}
