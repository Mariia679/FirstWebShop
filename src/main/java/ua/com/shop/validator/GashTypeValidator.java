package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.GashType;
import ua.com.shop.service.GashTypeService;

public class GashTypeValidator implements Validator {

	private final GashTypeService service;

	public GashTypeValidator(GashTypeService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return GashType.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		GashType gashType = (GashType) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(gashType.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
