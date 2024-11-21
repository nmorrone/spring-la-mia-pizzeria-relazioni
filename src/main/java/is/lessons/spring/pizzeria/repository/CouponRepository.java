package is.lessons.spring.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer>{

}
