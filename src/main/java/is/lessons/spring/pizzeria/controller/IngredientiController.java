package is.lessons.spring.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import is.lessons.spring.pizzeria.model.Ingrediente;
import is.lessons.spring.pizzeria.model.Pizza;
import is.lessons.spring.pizzeria.repository.IngredientiRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

	@Autowired
	IngredientiRepository ingredientiRepo;

	// metodo display elenco ingrediente
	@GetMapping
	public String index(Model model) {

		List<Ingrediente> ingredienti = ingredientiRepo.findAll();

		model.addAttribute("ingredienti", ingredienti);
		model.addAttribute("nuovoIngrediente", new Ingrediente());
		return "/pizze/lista-ingredienti";
	}

	@PostMapping("/inserisci-ingrediente")
	public String storeIngrediente(@Valid @ModelAttribute Ingrediente ingredienteForm, BindingResult bindingResults,
			Model model) {

		if (bindingResults.hasErrors()) {
			return "/pizze/lista-ingredienti";
		}

		ingredientiRepo.save(ingredienteForm);
		return "redirect:/ingredienti";
	}

	//metodo di rimozione ingrediente con rimozione da lista ingredienti pizze associate
	@PostMapping("/rimuovi-ingrediente/{id}")
	public String rimuoviIngrediente(@PathVariable("id") Integer id) {
		Ingrediente ingrediente = ingredientiRepo.findById(id).get();
		
		for(Pizza pizza : ingrediente.getPizze()) {	
			pizza.getIngredienti().remove(ingrediente);
		}
		
		ingredientiRepo.deleteById(id);
		return "redirect:/ingredienti";
	}

}
