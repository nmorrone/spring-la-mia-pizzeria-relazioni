package is.lessons.spring.pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Pizza;

public interface PizzeRepository extends JpaRepository <Pizza, Integer> {

	
	public List <Pizza> findByNomePizzaOrDescrizioneContaining(String nome, String descrizione);
	
}
