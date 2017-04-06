package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Ferula;
import ua.com.shop.service.FerulaService;

public class FerulaEditor extends PropertyEditorSupport {

	private final FerulaService service;

	public FerulaEditor(FerulaService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Ferula ferula = service.findOne(Long.valueOf(text));
		setValue(ferula);
	}
}
