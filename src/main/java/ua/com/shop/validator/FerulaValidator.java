package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Ferula;
import ua.com.shop.service.FerulaService;

public class FerulaValidator implements Validator {

	private final FerulaService service;

	public FerulaValidator(FerulaService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return Ferula.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Ferula ferula = (Ferula) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(ferula.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
