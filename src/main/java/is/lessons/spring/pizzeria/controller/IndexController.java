package is.lessons.spring.pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("/p")
	public String index() {
		
		return "redirect:/pizze";
	}

}
