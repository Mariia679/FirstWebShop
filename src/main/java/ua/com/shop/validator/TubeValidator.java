package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.TubeForm;
import ua.com.shop.service.TubeService;

public class TubeValidator implements Validator {

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	private final TubeService service;

	public TubeValidator(TubeService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return TubeForm.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		TubeForm tube = (TubeForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can't be empty");
		if (!REG.matcher(tube.getPrice()).matches()) {
			errors.rejectValue("price", "", "Can be only numbers");
		} else if (errors.getFieldError("price") == null) {
			if (service.findByName(tube.getName()) != null) {
				errors.rejectValue("name", "", "Already exist");
			}
		}
	}
}