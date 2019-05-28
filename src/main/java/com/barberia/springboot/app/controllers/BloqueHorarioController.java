package com.barberia.springboot.app.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberia.springboot.app.models.entity.BloqueHorario;
import com.barberia.springboot.app.models.service.ServicioBloqueHorario;

@RestController
@RequestMapping("/bloquehorario")
public class BloqueHorarioController {
	@Autowired
	@Qualifier("serviciobloquehorario")
	ServicioBloqueHorario servicio ;
	
	@PutMapping("/insertarbloquehorario")
	public boolean insertarBloque(@RequestBody @Valid BloqueHorario bloque) {
		return servicio.insertarBloque(bloque) ;
	}
	
	@DeleteMapping("borrarbloque/{idBloque}")
	public boolean borrarBloque(@PathVariable("idBloque")long idBloque) {
		return servicio.eliminarBloque(idBloque) ;
	}
	
	@PostMapping("modificarbloquehorario")
	public boolean modificarBloque(@RequestBody @Valid BloqueHorario bloque) {
		return servicio.modificarBloque(bloque);
	}
}
