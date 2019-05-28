package com.barberia.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barberia.springboot.app.models.service.IServicioServiceImpl;
import com.barberia.springboot.app.models.entity.Servicio;

import java.util.List;

@RestController
@Controller
@RequestMapping(value = "/servicios")
public class ServicioController {

	@Autowired
	private IServicioServiceImpl servicioService;
	 //listar servicios
		@GetMapping(value ="/listarServicios", produces = {"application/json"})
		public ResponseEntity< List<Servicio>> listar(){
			List<Servicio>lista = servicioService.findAll();
	    	if (lista.isEmpty()) {
				return new ResponseEntity<List<Servicio>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Servicio>>(lista, HttpStatus.OK); 
		}
	//agregar servicio
		@PostMapping (value= "/ingresarServicio")
		public ResponseEntity<Servicio> ingresar(@RequestBody Servicio servicio) {
			
			if (servicioService.exists(servicio.getId())!=false) {
				return new ResponseEntity<Servicio>(HttpStatus.NOT_ACCEPTABLE);
			}
			servicioService.save(servicio);
			return new ResponseEntity<Servicio>(servicio, HttpStatus.CREATED);  
		}
		//actualizar servicio
		@PutMapping(value="/ActualizarServicio/{id}")
		public ResponseEntity<Servicio> update(@RequestBody Servicio servicio, @PathVariable Long id) {
			
			Servicio servicioActual = servicioService.findOne(id);

			if (servicioActual == null) {
				return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
			} 
			servicioActual.setNombre(servicio.getNombre());
			servicioActual.setDuracion(servicio.getDuracion());
			servicioActual.setPrecio(servicio.getPrecio());
			servicioService.save(servicioActual);
			return new ResponseEntity<Servicio>(servicioActual, HttpStatus.ACCEPTED);
		}
		// eliminar Servicio
		@DeleteMapping(value= "/eliminarServicio/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			
			Servicio servicioActual = servicioService.findOne(id);
	    	if (servicioActual == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
	    	servicioService.delete(id);
	    	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
}
