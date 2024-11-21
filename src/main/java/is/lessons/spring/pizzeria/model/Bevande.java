package is.lessons.spring.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "bevande")
public class Bevande {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeBevanda;
	private double prezzo;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeBevanda() {
		return nomeBevanda;
	}
	public void setNomeBevanda(String nomeBevanda) {
		this.nomeBevanda = nomeBevanda;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "Bevande [id=" + id + ", nomeBevanda=" + nomeBevanda + ", prezzo=" + prezzo + "]";
	}
	
	
}
