package service.common;

import java.util.List;

import dataproviders.base.IBaseRepository;

public abstract class CrudServiceImpl<T> implements ICrudService<T> {

	
	abstract IBaseRepository<T> getRepository(); 
	@Override
	public T create(T entity) {
		// TODO Auto-generated method stub
		return getRepository().create(entity);
	}

	@Override
	public T read(int id) {
		// TODO Auto-generated method stub
		return getRepository().findById(id);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return getRepository().update(entity);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		getRepository().delete(id);
	}
	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return getRepository().listAll();
	}

}
