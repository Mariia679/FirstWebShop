package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.City;
import ua.com.shop.service.CityService;

public class CityEditor  extends PropertyEditorSupport {

	private final CityService service;

	public CityEditor(CityService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		City city = service.findOne(Long.valueOf(text));
		setValue(city);
	}
}
