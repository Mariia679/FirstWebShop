package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.service.CarvingJointService;

public class CarvingJointEditor extends PropertyEditorSupport {

	private final CarvingJointService service;

	public CarvingJointEditor(CarvingJointService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		CarvingJoint carvingJoint = service.findOne(Long.valueOf(text));
		setValue(carvingJoint);
	}
}
