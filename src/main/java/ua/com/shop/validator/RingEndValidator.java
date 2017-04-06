package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.RingEnd;
import ua.com.shop.service.RingEndService;

public class RingEndValidator implements Validator {

	private final RingEndService service;

	public RingEndValidator(RingEndService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return RingEnd.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		RingEnd ringEnd = (RingEnd) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(ringEnd.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
