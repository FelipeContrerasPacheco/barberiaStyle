package com.barberia.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {
	
	@GetMapping("/")
	public String hola(Model model) {
		String mensaje="Proyecto Semestral";
		model.addAttribute("mensaje",mensaje);
		return "index";
	}
	
}
