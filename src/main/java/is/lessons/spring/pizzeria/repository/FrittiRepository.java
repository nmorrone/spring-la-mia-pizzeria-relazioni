package is.lessons.spring.pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Fritti;

public interface FrittiRepository extends JpaRepository<Fritti, Integer>{
	public List <Fritti> findByNomeFrittoContaining(String nome);

}
