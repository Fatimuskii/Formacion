package service.common;

import java.util.List;

public interface ICrudService<T> {
	
	T create(T entity); 
	T read(int id); 
	T update(T entity); 
	void delete(int id); 
	List<T> list();

}
