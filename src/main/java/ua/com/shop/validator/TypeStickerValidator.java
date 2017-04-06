package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.TypeSticker;
import ua.com.shop.service.TypeStickerService;

public class TypeStickerValidator implements Validator {

	private final TypeStickerService service;

	public TypeStickerValidator(TypeStickerService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return TypeSticker.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		TypeSticker typeSticker = (TypeSticker) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (service.findByName(typeSticker.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
