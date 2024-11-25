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

	//metodo per rimuovere coupon con redirect sulla pizza associara
	@PostMapping("/{id}/rimuovi")
	public String rimuoviCoupon(@PathVariable("id") Integer id) {
		
		Integer redirect = couponRepo.findById(id).get().getPizza().getId();
		couponRepo.deleteById(id);
		
		return"redirect:/pizze/" + redirect;
	}
	
	
}
