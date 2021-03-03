package service.imp;

import java.util.List;

import dataproviders.base.IBaseRepository;
import dataproviders.dao.Cancion;
import dataproviders.repository.ICancionRepository;
import service.ICancionService;
import service.common.CrudServiceImpl;

public class CancionServiceImp extends CrudServiceImpl<Cancion> implements ICancionService {

	
	ICancionRepository cancionRepo;
	
	@Override
	public List<Cancion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancion save(Cancion cancion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	IBaseRepository<Cancion> getRepository() {
		// TODO Auto-generated method stub
		return cancionRepo;
	}

}
