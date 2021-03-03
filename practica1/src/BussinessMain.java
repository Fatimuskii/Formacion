

public class BussinessMain {

	public static void main(String[] args) {

		// Conectamos el dataSource
		ThisApplication app;
		try {
			app = new ThisApplication();
			if(app.config()) { // Se ha conectado a la BBDD
				app.run();
			}
			
		}catch(Exception e ) {
			System.out.println("No se ha podido iniciar la aplicación de la discografica.\n");
		}

	}
	
	
}
