package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

	Connection con = null;

	public DataSource() {
		
	}

	public boolean connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/discografica?useSSL=false", "root", "1234");
			
			return true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al intentar conectarse a la BBDD\n" + e.getMessage());
			e.printStackTrace();
		}
		
		return false; 
	}

	// Para cerrar la conexion
	public void closeConnection() {

		try {
			if (con != null && !((java.sql.Connection) con).isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Problema al cerrar la conexión con la BBDD\n");
		}
	}

	public CdDAO getCdDAO() {
		return new CdDAOImpl(this);
	}

	// Metodos CRUD

	public int create(String query) {
		int id = -100;

		try {
			Statement statement = con.createStatement();
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {

				id = rs.getInt(1);
				System.out.println("Nuevo cd introducido con id: " + id + "\n");
			}
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	public Cd read(String query) {
		Cd disco = null; 

		try {
			
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
				
				if(resultSet.next()) {
					disco = new Cd(
							resultSet.getInt("id"),
							resultSet.getString("artist"),
							resultSet.getString("name"),
							resultSet.getInt("year")
							);
				}
				
				statement.close();
				
			
		}catch( Exception e){
			// TODO: handle exception
			System.out.println("Error sql Read");
		}

		return disco;
	}

	public int update(String query) {
		int id = -100; 
		
		try {

			Statement statement = con.createStatement();
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {

				id = rs.getInt(1);
				System.out.println("Cd modificado con id: " + id + "\n");
			}
			statement.close();
		

		} catch (SQLException e) {
		
			System.out.println("Error sql Update");
		}
		
		return id; 
	}
	
	public int delete(String query) {

		int res= -100; 
		try {
		
			Statement statement = con.createStatement();
			//String query = "DELETE FROM product WHERE id=" + id;
			
			int result = statement.executeUpdate(query);
			

			if (result == 0) {
				System.out.println("Se ha borrado el registro");
				res = 1;
			}
			
			statement.close();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error sql Delete");
			e.printStackTrace();
		}
		
		return res; 
	}
	
	public List<Cd> list(String query) {
		List<Cd> list =  new ArrayList<>();
		
		try {

			Statement statement = con.createStatement();
	
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String artist = resultSet.getString("artist");
                int year= resultSet.getInt("year");

                Cd obj = new Cd(id, artist, name, year);

                list.add(obj); 
          
            }
			
			statement.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error sql List");
			e.printStackTrace();
		}
		
		return list;
	}
		


}
