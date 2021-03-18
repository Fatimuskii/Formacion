package dataproviders.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

public class BaseRepositoryImp<T> implements IBaseRepository<T> {

	
	private Class<T> type; 
	private EntityManager em; 
	
	@SuppressWarnings("unchecked")
	public BaseRepositoryImp() {
		// TODO Auto-generated constructor stub
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)t; 
		type = (Class<T>)pt.getActualTypeArguments()[0];
		
	}
	
	public EntityManager getEntityManager() {
		return this.em; 
	}
	@Override
	public T create(T entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return em.find(type, id);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity; 
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(type, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from "+ type.getSimpleName() + " e").getResultList();
	}

}
