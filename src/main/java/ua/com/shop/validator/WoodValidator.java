package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Wood;
import ua.com.shop.service.WoodService;

public class WoodValidator implements Validator {

	private final WoodService service;

	public WoodValidator(WoodService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return Wood.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Wood wood = (Wood) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(wood.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
