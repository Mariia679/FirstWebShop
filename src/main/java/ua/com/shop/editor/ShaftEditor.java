package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Shaft;
import ua.com.shop.service.ShaftService;

public class ShaftEditor extends PropertyEditorSupport {

	private final ShaftService service;

	public ShaftEditor(ShaftService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Shaft shaft = service.findOne(Long.valueOf(text));
		setValue(shaft);
	}
}