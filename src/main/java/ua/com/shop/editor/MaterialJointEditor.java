package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.service.MaterialJointService;

public class MaterialJointEditor extends PropertyEditorSupport {

	private final MaterialJointService service;

	public MaterialJointEditor(MaterialJointService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		MaterialJoint materialJoint = service.findOne(Long.valueOf(text));
		setValue(materialJoint);
	}
}
