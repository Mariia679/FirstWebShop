package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Damper;
import ua.com.shop.service.DamperService;

public class DamperEditor extends PropertyEditorSupport {

	private final DamperService service;

	public DamperEditor(DamperService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Damper damper = service.findOne(Long.valueOf(text));
		setValue(damper);
	}
}
