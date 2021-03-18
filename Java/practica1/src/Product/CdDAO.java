package Product;

import java.util.List;

public interface CdDAO {

	public int create(Cd disc);
	public Cd read(int id); 
	public int update(Cd productU);
	public int delete(int id); 
	public List<Cd> list(); 
}
