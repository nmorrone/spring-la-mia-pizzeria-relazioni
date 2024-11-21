package is.lessons.spring.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import is.lessons.spring.pizzeria.repository.CouponRepository;

@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	private CouponRepository couponRepo;

}
