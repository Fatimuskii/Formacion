package dataproviders.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Cancion.findById", query = "select obj from canciones obj where :id = obj.id "),
		@NamedQuery(name = "Cancion.findByNombre", query = "select obj from canciones obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Cancion.findByAnio", query = "select obj from canciones obj where :anio = obj.anio "),
		@NamedQuery(name = "Cancion.findAll", query = "select obj from canciones"), })
@Table(name = "canciones")

public class Cancion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "anio")
	private int anio;

	public Cancion() {

	}

	public Cancion(int id, String nombre, int year) {

		this.id = id;
		this.nombre = nombre;
		this.anio = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	

	
	

}
