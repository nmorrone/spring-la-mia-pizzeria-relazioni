package is.lessons.spring.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Ingrediente;

public interface IngredientiRepository extends JpaRepository<Ingrediente, Integer> {

}
