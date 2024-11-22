package is.lessons.spring.pizzeria.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "pizze")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Devi inserire il nome della Pizza")
	@NotBlank(message = "Devi inserire il nome della Pizza")
	private String nomePizza;
	@NotNull(message = "Inserisci gli ingredienti della pizza separati dalle virgole")
	@NotBlank(message = "Inserisci gli ingredienti della pizza separati dalle virgole")
	private String descrizione;
	private String linkFoto; 
	@NotNull(message = "Devi inserire il prezzo della Pizza")
	@Min(value = 5, message = "il prezzo non può essere inferiore a euro 5")
	private double prezzo;
	
	@OneToMany(mappedBy="pizza")
	private List<Coupon> coupons;
	
	//collego con tab ponte da me denominata gli ingredienti
	@ManyToMany()
	@JoinTable(
			name = "pizza_ingredienti",
			joinColumns = @JoinColumn(name="pizza_id"),
			inverseJoinColumns = @JoinColumn (name = "ingrediente_id")
			)
	private List<Ingrediente> ingredienti;
	
	
	
	//getters setters methods
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePizza() {
		return nomePizza;
	}
	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nomePizza=" + nomePizza + ", descrizione=" + descrizione + ", linkFoto="
				+ linkFoto + ", prezzo=" + prezzo + "]";
	}
	
	
	
	

}
