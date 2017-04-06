package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Shaft;
import ua.com.shop.service.ShaftService;

public class ShaftValidator implements Validator {

	private final ShaftService service;

	public ShaftValidator(ShaftService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return Shaft.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Shaft shaft = (Shaft) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(shaft.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
