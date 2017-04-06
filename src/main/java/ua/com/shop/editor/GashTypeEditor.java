package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.GashType;
import ua.com.shop.service.GashTypeService;

public class GashTypeEditor extends PropertyEditorSupport {

	private final GashTypeService service;

	public GashTypeEditor(GashTypeService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		GashType gashType = service.findOne(Long.valueOf(text));
		setValue(gashType);
	}
}
