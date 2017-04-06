package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.RingBumper;
import ua.com.shop.service.RingBumperService;

public class RingBumperValidator implements Validator {

	private final RingBumperService service;

	public RingBumperValidator(RingBumperService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return RingBumper.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		RingBumper ringBumper = (RingBumper) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(ringBumper.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
