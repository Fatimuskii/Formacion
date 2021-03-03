
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ArtistManager {

	protected SessionFactory sessionFactory;

	protected void config() {
		// A SessionFactory is set up once for an application
		sessionFactory = new Configuration().configure("hibernate.cfg.xml") // configures settings from
																			// hibernate.cfg.xml
				.buildSessionFactory();

	}

	protected void exit() {
		// code to close Hibernate Session factory
	}

	protected void create() {
		// code to create an artist
		Artist artist1 = new Artist();
		artist1.setName("Lady Gaga");
		artist1.setRealName("Stefani Joanne Angelina Germanotta");

		Artist artist2 = new Artist();
		artist2.setName("Menganito");
		artist2.setRealName("Menganito real");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(artist1);
		session.save(artist2);

		session.getTransaction().commit();
		session.close();
		
	}

	protected void read() {
		// code to get an artist
		int id = 1;

		System.out.println("Se va a buscar el registro del artista con id: " + id);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Artist artist = session.find(Artist.class, id);
		System.out.println(" El nombre del artista con id " + id + " es: " + artist.getName());

		session.getTransaction().commit();
		session.close();

	}

	protected void update() {
		// code to modify an artist
		int id = 1;
		System.out.println("Se va a modificar el registro del artista con id: " + id);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Artist artist = session.find(Artist.class, id);
		artist.setRealName("Stefani Joanne");

		session.getTransaction().commit();
		session.close();
	}

	protected void delete() {
		// code to remove an artist
		int id = 1;

		System.out.println("Se va a borrar el registro del artista con id: " + id);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Artist artist = session.find(Artist.class, id);
		session.remove(artist);
		

		session.getTransaction().commit();
		session.close();

	}

	protected void list() {
		System.out.println("Lista actual de artistas en la BBDD");
		Session session = sessionFactory.openSession();
		session.beginTransaction();

	}

	public static void main(String[] args) {
		// code to run the program

		ArtistManager manager = new ArtistManager();
		manager.config();

		manager.create();
		manager.read();
		manager.update();
		manager.delete();
		manager.exit();
	}

}
