import java.util.List;

import Product.Cd;
import Product.CdDAO;
import Product.DataSource;

public class ThisApplication {

	private static DataSource dataSource; 
	

	// Bloque estático que en el momento se aplica esta clase, se ejecuta
	
	static {
		// Leemos de un fichero de configuracion
		
	}
	public DataSource getDataSource() {
		if (this.dataSource == null) {
			this.dataSource = new DataSource(); 
		}
		
		return this.dataSource; 
	}
	
	public boolean config() {
		
		try {
			if(getDataSource()!= null) {
				if(dataSource.connect()) {
					return true; 
				}
				
			}
			else {
				System.out.println("Ha ocurrido un error en la conexión con la BBDD");
			}
				
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		
		return false; 
	}


	
	public void run () {
		CdDAO cdDAO = dataSource.getCdDAO(); 

		crear(cdDAO); 
		
		// Hacemos un list para ver que existen 3: 
		listar(cdDAO); 
		
		buscar(cdDAO); 
		
		modificar(cdDAO); 
		
		listar(cdDAO); 
		
		eliminar(cdDAO); 
		
		listar(cdDAO); 
		
		dataSource.closeConnection();

	}
	
	public void crear(CdDAO cdDAO) {
		System.out.println(" ------- CREATE ---------\n");
		// Create
		Cd disco1 = new Cd("LP", "Girls go wild", 2020); 
		Cd disco2 = new Cd("Linkin Park", "Meteora", 2003); 
		Cd disco3 = new Cd("Avicii", "Stories", 2015);
				
		int id1 = cdDAO.create(disco1);
		int id2 = cdDAO.create(disco2);
		int id3 = cdDAO.create(disco3);
		if(id1 >0 && id2 > 0 && id3 >0) {
			System.out.println("Se han introducido los 3 registros correctamente.\n");
		}
		else {
			System.out.println("No se han introducido los 3 registros correctamente. \n");
		}
				
	}
	
	public void listar(CdDAO cdDAO) {
		System.out.println(" ------- LIST ---------\n");
		System.out.println("Lista de CD's actuales: \n");
		List<Cd>lista = cdDAO.list();
		if(!lista.isEmpty()) {
			for(Cd i: lista) {
				System.out.println(" | " + i.toString());
			}
		}
		
		else {
			System.out.println("No hay registros en la BBDD");
		}
		
		
	}
	
	public void buscar(CdDAO cdDAO) {
		System.out.println(" ------- READ ---------\n");
		// Read
		Cd buscar = cdDAO.read(2);
		if (buscar != null) {
			System.out.println("El disco con id:" + buscar.getId() + " es de " + buscar.getArtist() +
					" con album "+ buscar.getName()+ " sacado en el año " + buscar.getYear() + "\n");
		}
		else {
			System.out.println("No se ha encontrado el registro.");
		}
		
	}
	
	public void modificar(CdDAO cdDAO) {
		System.out.println(" ------- UPDATE ---------\n");
		// Update
		Cd act = new Cd(1, "Laura Pergolizzi", "GIRLS GO WILD", 2020);
	
		System.out.println("Se va a modificar el CD con id: " +act.getId());
		int discoActualizado = cdDAO.update(act);
		if(discoActualizado == act.getId()) {
			System.out.println("El disco con id:" + discoActualizado + " se ha actualizado correctamente.");
		}
		else {
			System.out.println("No se han modificado los datos correctamente.\n");
		}
		
	}
	
	public void eliminar(CdDAO cdDAO) {
		System.out.println(" ------- DELETE ---------\n");
		
		int id =3; 
		// Delete
		System.out.println("Se va a eliminar el CD con id: " +id);
		int res= cdDAO.delete(id);
		if(res !=100) {
			System.out.println("Se ha borrado correctamente el registro con id: " + id);
		}
		else {
			System.out.println("No se ha podido eliminar el registro con id: " + id);
		}
	}
	
	
}
