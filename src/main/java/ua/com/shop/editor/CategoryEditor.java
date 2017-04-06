package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {

	private final CategoryService service;

	public CategoryEditor(CategoryService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Category category = service.findOne(Long.valueOf(text));
		setValue(category);
	}
}
