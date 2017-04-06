package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.RingBumper;
import ua.com.shop.service.RingBumperService;

public class RingBumperEditor extends PropertyEditorSupport {

	private final RingBumperService service;

	public RingBumperEditor(RingBumperService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		RingBumper ringBumper = service.findOne(Long.valueOf(text));
		setValue(ringBumper);
	}
}
