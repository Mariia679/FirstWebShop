package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Butt;
import ua.com.shop.service.ButtService;

public class ButtEditor extends PropertyEditorSupport {

	private final ButtService service;

	public ButtEditor(ButtService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Butt butt = service.findOne(Long.valueOf(text));
		setValue(butt);
	}
}
