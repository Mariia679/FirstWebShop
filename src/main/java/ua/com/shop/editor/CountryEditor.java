package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Country;
import ua.com.shop.service.CountryService;

public class CountryEditor extends PropertyEditorSupport {

	private final CountryService service;

	public CountryEditor(CountryService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Country country = service.findOne(Long.valueOf(text));
		setValue(country);
	}
}
