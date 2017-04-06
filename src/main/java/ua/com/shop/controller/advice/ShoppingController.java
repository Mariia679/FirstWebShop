package ua.com.shop.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.com.shop.dto.cart.Quantity;
import ua.com.shop.service.CommodityService;

@ControllerAdvice
public class ShoppingController {

	@Autowired
	private CommodityService commodityService;

	@ModelAttribute("quantity")
	public Quantity getQuantity(
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		Long count = commodityService.findCount(userId);
		return new Quantity(count);
	}
}
