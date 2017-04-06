package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Butt;
import ua.com.shop.service.ButtService;

public class ButtValidator implements Validator {

	private final ButtService buttService;

	public ButtValidator(ButtService buttService) {
		this.buttService = buttService;
	}

	public boolean supports(Class<?> arg0) {
		return Butt.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Butt butt = (Butt) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (buttService.findByName(butt.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}

	}
}
