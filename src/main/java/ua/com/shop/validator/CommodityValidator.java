package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.service.CommodityService;

public class CommodityValidator implements Validator {

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	private final CommodityService commodityService;

	public CommodityValidator(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public boolean supports(Class<?> clazz) {
		return CommodityForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		CommodityForm form = (CommodityForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "length", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can't be empty");
		if (form.getButt() == null || form.getCarvingJoint() == null
				|| form.getCategory() == null || form.getDamper() == null
				|| form.getFerula() == null || form.getGashType() == null
				|| form.getMainMaterial() == null
				|| form.getMaterialJoint() == null
				|| form.getRingBumper() == null || form.getRingEnd() == null
				|| form.getShaft() == null || form.getSticker() == null
				|| form.getTypeSticker() == null || form.getWood() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mainMaterial",
					"", "Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wood",
					"", "Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ferula", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gashType", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shaft", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "butt", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sticker", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeSticker",
					"", "Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ringEnd", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ringBumper", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "damper", "",
					"Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carvingJoint",
					"", "Can't be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialJoint",
					"", "Can't be empty");

		}
		else if (!REG.matcher(form.getPrice()).matches()) {
			errors.rejectValue("price", "", "Can be only numbers");
		}
		else if (errors.getFieldError("price") == null) {
			if (commodityService.findUnique(form.getButt(),
					form.getCarvingJoint(), form.getCategory(),
					form.getDamper(), form.getFerula(), form.getGashType(),
					form.getLength(), form.getMainMaterial(),
					form.getMaterialJoint(), form.getName(), form.getPrice(),
					form.getRingBumper(), form.getRingEnd(), form.getShaft(),
					form.getSticker(), form.getTypeSticker(), form.getWeight(),
					form.getWood()) != null) {
				errors.rejectValue("name", "", "Aready exist");
			}
		}
	}
}
