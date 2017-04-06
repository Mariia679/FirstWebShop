package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Wood;
import ua.com.shop.service.WoodService;

public class WoodEditor extends PropertyEditorSupport {

	private final WoodService service;

	public WoodEditor(WoodService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Wood wood = service.findOne(Long.valueOf(text));
		setValue(wood);
	}

}
