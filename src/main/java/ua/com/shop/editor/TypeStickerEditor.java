package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.TypeSticker;
import ua.com.shop.service.TypeStickerService;

public class TypeStickerEditor extends PropertyEditorSupport {

	private final TypeStickerService service;

	public TypeStickerEditor(TypeStickerService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TypeSticker sticker = service.findOne(Long.valueOf(text));
		setValue(sticker);
	}
}
