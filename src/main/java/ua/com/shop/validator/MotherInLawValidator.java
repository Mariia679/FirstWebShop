package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.MotherInLawForm;
import ua.com.shop.service.MotherInLawService;

public class MotherInLawValidator implements Validator {

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	private final MotherInLawService service;

	public MotherInLawValidator(MotherInLawService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return MotherInLawForm.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		MotherInLawForm motherInLaw = (MotherInLawForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can't be empty");
		if (!REG.matcher(motherInLaw.getPrice()).matches()) {
			errors.rejectValue("price", "", "Can be only numbers");
		} else if (errors.getFieldError("price") == null) {
			if (service.findByName(motherInLaw.getName()) != null) {
				errors.rejectValue("name", "", "Already exist");
			}
		}
	}

}
