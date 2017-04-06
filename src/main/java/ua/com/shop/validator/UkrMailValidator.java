package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.UkrMail;
import ua.com.shop.service.UkrMailService;

public class UkrMailValidator implements Validator {

	private final UkrMailService service;

	public UkrMailValidator(UkrMailService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return UkrMail.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {

		UkrMail ukrMail = (UkrMail) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "",
				"Can't be empty");
		if (ukrMail.getCity() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "",
					"Can't be empty");
		} else if (service.findUnique(ukrMail.getDepartment(),
				ukrMail.getCity()) != null) {
			errors.rejectValue("department", "", "Already exist");
		}
	}
}
