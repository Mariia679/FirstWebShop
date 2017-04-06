package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.MainMaterial;
import ua.com.shop.service.MainMaterialService;

public class MainMaterialValidator implements Validator {

	private final MainMaterialService service;

	public MainMaterialValidator(MainMaterialService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return MainMaterial.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		MainMaterial mainMaterial = (MainMaterial) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(mainMaterial.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
