package Product;

import java.util.Calendar;

public class Cd {

	
	private CdDTO dto; 
	
	public Cd(CdDTO dto) {

		this.dto= dto; 
	}
	
	public Cd(String name, String artist, int year) {
		this.dto = new CdDTO(); 
		this.dto.name = name;
		this.dto.artist = artist; 
		this.dto.year = year; 
		
	}

	public Cd(int id, String artist, String name, int year) {
		// TODO Auto-generated constructor stub
		this.dto = new CdDTO();
		this.dto.id = id; 
		this.dto.name = name;
		this.dto.artist = artist; 
		this.dto.year = year; 
	}

	public int getId() {
		return dto.id;
	}
	public void setId(int id) {
		this.dto.id = id;
	}
	public String getArtist() {
		return this.dto.artist;
	}
	public void setArtist(String artist) {
		this.dto.artist = artist;
	}
	public int getYear() {
		return this.dto.year;
	}
	public void setYear(int year) {
		this.dto.year = year;
	}
	public String getName() {
		return this.dto.name;
	}
	public void setName(String name) {
		this.dto.name = name;
	} 
	
	public int yearsOld() {
		Calendar cal = Calendar.getInstance();
		int actYear= cal.get(Calendar.YEAR);
		
		return actYear - this.dto.year;
		
		
	}
	public String toString() {
		
		String res = ""; 
		
		//res+= "Id del CD: " + this.dto.id + " | Nombre del CD: " + this.dto.name + " | Artista: " + this.dto.artist + " | Año publicación : " + this.dto.year + "\n";  
		res+= "Id del CD: " + this.dto.id + " | Nombre del CD: " + this.dto.name + " | Artista: " + this.dto.artist + " | Antigüedad : " + yearsOld() + " año(s)\n";  
		return res; 
	
	}
}
