package com.barberia.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String hola(Model model) {
<<<<<<< HEAD
		String mensaje="Proyecto Semestral de gestion";
=======
		String mensaje="Proyecto Semestral holla";
>>>>>>> branch 'alvaro' of https://github.com/FelipeContrerasPacheco/barberiaStyle.git
		model.addAttribute("mensaje",mensaje);
		return "index";
	}
	
}
