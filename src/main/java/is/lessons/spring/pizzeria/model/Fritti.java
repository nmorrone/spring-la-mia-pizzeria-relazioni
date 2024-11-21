package is.lessons.spring.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "fritti")
public class Fritti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String nomeFritto;
	private double prezzo;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeFritto() {
		return nomeFritto;
	}
	public void setNomeFritto(String nomeFritto) {
		this.nomeFritto = nomeFritto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Fritti [id=" + id + ", nomeFritto=" + nomeFritto + ", prezzo=" + prezzo + "]";
	}
	
	
	

}
