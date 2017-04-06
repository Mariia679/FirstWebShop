package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.MainPage;
import ua.com.shop.service.MainPageService;

public class MainPageValidator implements Validator {

	private final MainPageService service;

	public MainPageValidator(MainPageService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return MainPage.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		MainPage form = (MainPage) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "",
				"Can't be empty");
		if (service.findUnique(form.getName(), form.getContent()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}

	}
}
