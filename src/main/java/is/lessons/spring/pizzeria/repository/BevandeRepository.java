package is.lessons.spring.pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Bevande;

public interface BevandeRepository extends JpaRepository<Bevande, Integer>{
	public List <Bevande> findByNomeBevandaContaining(String nome);

}
