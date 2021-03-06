package com.barberia.springboot.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="servicio")
public class Servicio {
	
	@Id
	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private Integer Duracion;
	@NotEmpty
	private Integer Precio;
	
	public Servicio() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDuracion() {
		return Duracion;
	}
	public void setDuracion(Integer duracion) {
		Duracion = duracion;
	}
	public Integer getPrecio() {
		return Precio;
	}
	public void setPrecio(Integer precio) {
		Precio = precio;
	}
	
}
