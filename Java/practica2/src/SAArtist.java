import java.util.List;
;

public interface SAArtist {

	public int create(Artist artist);
	public Artist read(int id); 
	public int update(Artist artistUpdated);
	public int delete(int id); 
	public List<Artist> list(); 
}
