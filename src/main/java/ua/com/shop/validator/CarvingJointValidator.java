package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.service.CarvingJointService;

public class CarvingJointValidator implements Validator {

	private final CarvingJointService carvingJointService;

	public CarvingJointValidator(CarvingJointService carvingJointService) {
		this.carvingJointService = carvingJointService;
	}

	public boolean supports(Class<?> arg0) {
		return CarvingJoint.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		CarvingJoint carvingJoint = (CarvingJoint) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (carvingJointService.findByName(carvingJoint.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}

}