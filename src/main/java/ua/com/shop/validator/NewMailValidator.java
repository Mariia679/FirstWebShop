package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.NewMail;
import ua.com.shop.service.NewMailService;

public class NewMailValidator implements Validator {

	private final NewMailService service;

	public NewMailValidator(NewMailService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return NewMail.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		NewMail newMail = (NewMail) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "",
				"Can't be empty");
		if (newMail.getCity() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "",
					"Can't be empty");
		} else if (service.findUnique(newMail.getDepartment(),
				newMail.getCity()) != null) {
			errors.rejectValue("department", "", "Already exist");
		}
	}
}
