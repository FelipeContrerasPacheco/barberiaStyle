package com.barberia.springboot.app.models.service;

import java.util.List;
import com.barberia.springboot.app.models.entity.BloqueHorario;

public interface IBloqueHorarioService {
	
	public List<BloqueHorario> findAll() ;
	
	public void save(BloqueHorario bloque);
	
	public BloqueHorario findOne(Long id);
	
	public void delete(Long id);
	
}
