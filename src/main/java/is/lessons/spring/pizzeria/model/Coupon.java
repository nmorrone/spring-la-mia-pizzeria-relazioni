package is.lessons.spring.pizzeria.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table (name = "coupons")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDate inizio;
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
