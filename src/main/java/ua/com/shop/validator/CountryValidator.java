package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Country;
import ua.com.shop.service.CountryService;

public class CountryValidator implements Validator {

	private final CountryService service;

	public CountryValidator(CountryService service) {
		this.service = service;
	}

	public boolean supports(Class<?> arg0) {
		return Country.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Country country = (Country) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		if(service.findByName(country.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
