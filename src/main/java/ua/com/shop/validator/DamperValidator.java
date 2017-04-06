package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Damper;
import ua.com.shop.service.DamperService;

public class DamperValidator implements Validator {

	private final DamperService service;

	public DamperValidator(DamperService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return Damper.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Damper damper = (Damper) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(damper.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
