package is.lessons.spring.pizzeria.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "coupons")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull (message = "Inserisci 5 caratteri per dare un nome alla tua offerta")
	@NotBlank (message = "Inserisci 5 caratteri per dare un nome alla tua offerta")
	@Size(min = 5, max = 5, message="Il nome del Coupon deve essere obbligatiriamente di 5 caratteri")
	private String nome;
	@NotNull(message = "Inserisci la data di inizio dell'offerta")
	@FutureOrPresent(message = "La data di inizio non può essere precedente ad oggi")
	private LocalDate inizio;
	@NotNull(message = "L'offerta deve avere una data di scadenza")
	@FutureOrPresent(message = "La data di fine non può essere precedente ad oggi")
	private LocalDate fine;
	
	@ManyToOne
	@JoinColumn(name="pizza_id", nullable = false)
	private Pizza pizza;
	
	
	
	//metodi getters and setters
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	//metodi getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getInizio() {
		return inizio;
	}
	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}
	public LocalDate getFine() {
		return fine;
	}
	public void setFine(LocalDate fine) {
		this.fine = fine;
	}
	
	
	
	
	

}
