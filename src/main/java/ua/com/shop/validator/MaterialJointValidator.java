package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.service.MaterialJointService;

public class MaterialJointValidator implements Validator {

	private final MaterialJointService service;

	public MaterialJointValidator(MaterialJointService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return MaterialJoint.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		MaterialJoint materialJoint = (MaterialJoint) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(materialJoint.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
