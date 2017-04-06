package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.City;
import ua.com.shop.service.CityService;

public class CityValidator implements Validator {

	private final CityService cityService;

	public CityValidator(CityService cityService) {
		this.cityService = cityService;
	}

	public boolean supports(Class<?> arg0) {
		return City.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		City city = (City) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (city.getCountry() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "",
					"Can't be empty");
		} else if (cityService.findUnique(city.getName(), city.getCountry()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
