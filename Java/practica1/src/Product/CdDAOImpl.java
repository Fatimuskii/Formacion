package Product;

import java.util.ArrayList;
import java.util.List;

public class CdDAOImpl implements CdDAO {

	
	private DataSource dataSource; 
	
	public CdDAOImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.dataSource = dataSource; 
	}
	@Override
	public int create(Cd disc) {
		
		int id =-100; 

		String query = "INSERT INTO product (name, artist, year) VALUES ('"
		+ disc.getName() + "', '" + disc.getArtist() + "', " + disc.getYear() + ");" ;
		id = dataSource.create(query); 

		return id; 
	}

	@Override
	public Cd read(int id) {
		Cd disco = null; 
		
		String query = "SELECT * FROM product WHERE id=" + id + ";";
		disco = dataSource.read(query);
		
		return disco; 
	}

	@Override
	public int update(Cd cdUpdated) {
	
		String query = "UPDATE product SET "
				+ "name='" + cdUpdated.getName() + "', " 
				+ "artist='" +cdUpdated.getArtist() +"', "
				+ "year=" +cdUpdated.getYear()+ " "
				+ "WHERE id=" + cdUpdated.getId() + ";";

		int id = dataSource.update(query);
		
		return id; 
	}
	
	public List<Cd> list(){
		List<Cd> list =  new ArrayList<>();
		String query = "SELECT * FROM product;";
		
		list= dataSource.list(query);
		
		return list; 
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int res =-100; 
		String query = "DELETE FROM product WHERE id=" + id; 
		res = dataSource.delete(query); 
		
		return res; 
	}


}
