package is.lessons.spring.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import is.lessons.spring.pizzeria.model.Coupon;
import is.lessons.spring.pizzeria.repository.CouponRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/coupons")
public class CouponController {
	
	@Autowired
	private CouponRepository couponRepo;

	
	//metodo per rimuovere coupon
	@PostMapping("/{id}/rimuovi")
	public String rimuoviCoupon(@PathVariable("id") Integer id) {
		
		couponRepo.deleteById(id);
		
		return"redirect:/pizze";
	}
	
	
	//metodi per visualizzare e modificare coupon
	@GetMapping("/{id}/modifica-offerta")
	public String modificaCoupon(@PathVariable("id") Integer id, Model model) {
		
		Coupon offerta = couponRepo.findById(id).get();
		
		model.addAttribute("offerta", offerta);
		
		return "/pizze/modifica-offerta";
	}
	
	@PostMapping("/{id}/modifica-offerta")
	public String storeCoupon(@PathVariable("id") Integer id, @Valid @ModelAttribute("coupon") Coupon couponForm,BindingResult bindingResults,  Model model) {
		
		if(bindingResults.hasErrors()){
			
			return "/pizze/modifica-offerta";
		}
		
		couponRepo.save(couponForm);
		
		return "redirect:/pizze";
	}

	
}
