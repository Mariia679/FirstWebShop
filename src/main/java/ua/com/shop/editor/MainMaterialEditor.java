package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.MainMaterial;
import ua.com.shop.service.MainMaterialService;

public class MainMaterialEditor extends PropertyEditorSupport {

	private final MainMaterialService service;

	public MainMaterialEditor(MainMaterialService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		MainMaterial mainMaterial = service.findOne(Long.valueOf(text));
		setValue(mainMaterial);
	}

}
