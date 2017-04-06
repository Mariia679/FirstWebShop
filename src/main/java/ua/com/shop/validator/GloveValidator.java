package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.GloveForm;
import ua.com.shop.service.GloveService;

public class GloveValidator implements Validator {

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	private final GloveService service;

	public GloveValidator(GloveService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return GloveForm.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		GloveForm glove = (GloveForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can't be empty");
		if (!REG.matcher(glove.getPrice()).matches()) {
			errors.rejectValue("price", "", "Can be only numbers");
		} else if (errors.getFieldError("price") == null) {
			if (service.findByName(glove.getName()) != null) {
				errors.rejectValue("name", "", "Already exist");
			}
		}
	}
}
