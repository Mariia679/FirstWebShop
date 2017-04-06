package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.MethodDelivery;
import ua.com.shop.service.MethodDeliveryService;

public class MethodDeliveryValidator implements Validator {

	private final MethodDeliveryService service;

	public MethodDeliveryValidator(MethodDeliveryService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return MethodDelivery.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		MethodDelivery methodDelivery = (MethodDelivery) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "",
				"Can't be empty");
		if (service.findByTitle(methodDelivery.getTitle()) != null) {
			errors.rejectValue("title", "", "Already exist");
		}
	}
}
