package com.barberia.springboot.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="barberos")
public class Barbero {
	
	@Id
	private Long id;
	
	private String nombre;
	
}
