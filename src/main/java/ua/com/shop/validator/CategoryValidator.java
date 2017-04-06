package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

public class CategoryValidator  implements Validator {

	private final CategoryService categoryService;

	public CategoryValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public boolean supports(Class<?> arg0) {
		return Category.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (categoryService.findByName(category.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}

}
