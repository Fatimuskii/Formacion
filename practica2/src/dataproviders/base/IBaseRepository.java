package dataproviders.base;

import java.util.List;

public interface IBaseRepository<T> {

	T create(T t); 
	T findById(int id); 
	T update(T t); 
	void delete(int i); 
	List<T> listAll(); 
	
}
