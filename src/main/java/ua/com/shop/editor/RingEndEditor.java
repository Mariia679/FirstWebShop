package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.RingEnd;
import ua.com.shop.service.RingEndService;

public class RingEndEditor extends PropertyEditorSupport {

	private final RingEndService service;

	public RingEndEditor(RingEndService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		RingEnd ringEnd = service.findOne(Long.valueOf(text));
		setValue(ringEnd);
	}
}
