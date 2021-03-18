package service;

import java.util.List;

import dataproviders.dao.Cancion;
import service.common.ICrudService;

public interface ICancionService extends ICrudService<Cancion> {

	// aqui irian metedos mas especificos a parte del Crud

	List<Cancion> findAll(); 
	Cancion save(Cancion cancion); 
	Cancion findById(int id); 
	
}
