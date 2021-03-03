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

public class Artista {
	@Entity
	@NamedQueries({ @NamedQuery(name = "Artista.findById", query = "select obj from artistas obj where :id = obj.id "),
			@NamedQuery(name = "Artista.findByNombre", query = "select obj from artistas obj where :nombre = obj.nombre "),
			@NamedQuery(name = "Artista.findByNombreReal", query = "select obj from artistas obj where :nombreReal = obj.nombreReal "),
			@NamedQuery(name = "Artista.findAll", query = "select obj from artistas"), })
	@Table(name = "artistas")
	public class Artist implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 100000000L;

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(name = "nombre")
		private String nombre;

		@Column(name = "nombreReal")
		private String nombreReal;

		public Artist() {

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

		public String getNombreReal() {
			return nombreReal;
		}

		public void setNombreReal(String nombreReal) {
			this.nombreReal = nombreReal;
		}

	}
}
