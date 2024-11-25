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
import is.lessons.spring.pizzeria.repository.IngredientiRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {
	
	@Autowired
	IngredientiRepository ingredientiRepo;
	
	//metodo display elenco ingrediente
	@GetMapping("/")
	public String index(Model model) {
	List <Ingrediente> ingredienti = ingredientiRepo.findAll();	
	model.addAttribute("ingredienti", ingredienti);
	return "/pizze/lista-ingredienti";
	}
	//metodi form nuovo ingrediente e store in DB
	@GetMapping("/inserisci-ingrediente")
	public String formIngrediente(Model model) {
		
		model.addAttribute("ingrediente", new Ingrediente());
		return "pizze/crea-ingrediente";
	}
	
	@PostMapping("/inserisci-ingrediente")
	public String storeIngrediente (@Valid @ModelAttribute("ingrediente") Ingrediente ingredienteForm, BindingResult bindingResults, Model model){
		
		if(bindingResults.hasErrors()) {
			return"/ingredienti/crea-ingrediente";
		}
		
		ingredientiRepo.save(ingredienteForm);		
		return"redirect:/ingredienti";
	}
	
	@PostMapping("/rimuovi/{id}")
	public String rimuoviIngrediente(@PathVariable("id") Integer id) {
		ingredientiRepo.deleteById(id);
		
		return"redirect:/ingredienti";
	}

}
