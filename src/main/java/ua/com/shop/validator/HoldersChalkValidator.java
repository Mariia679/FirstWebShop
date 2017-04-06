package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.HoldersChalkForm;
import ua.com.shop.service.HoldersChalkService;

public class HoldersChalkValidator implements Validator {

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	private final HoldersChalkService service;

	public HoldersChalkValidator(HoldersChalkService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return HoldersChalkForm.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		HoldersChalkForm holdersChalk = (HoldersChalkForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can't be empty");
		if (!REG.matcher(holdersChalk.getPrice()).matches()) {
			errors.rejectValue("price", "", "Can be only numbers");
		} else if (errors.getFieldError("price") == null) {
			if (service.findByName(holdersChalk.getName()) != null) {
				errors.rejectValue("name", "", "Already exist");
			}
		}
	}
}
