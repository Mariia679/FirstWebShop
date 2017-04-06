package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

public class UserValidator implements Validator {

	private static final Pattern REG = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]*(\\.[A-Za-z]{2,})$");

	private final UserService service;

	public UserValidator(UserService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}
	//&& service.findByUsername(user.getUsername()) != null
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "",
				"Не может быть пустым");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "",
				"Не может быть пустым");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
				"Не может быть пустым");
		if (!REG.matcher(user.getEmail()).matches()) {
			errors.rejectValue("email", "", "Наверно вышла ошибочка=)");
		} else if (errors.getFieldError("email") == null) {
			if (service.findUnique(user.getEmail(),user.getUsername()) != null) {
				errors.rejectValue("username", "", "Already exist");
			}
		}
	}
}
