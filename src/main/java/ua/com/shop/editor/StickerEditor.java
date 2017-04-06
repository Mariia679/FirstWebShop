package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Sticker;
import ua.com.shop.service.StickerService;

public class StickerEditor extends PropertyEditorSupport {

	private final StickerService service;

	public StickerEditor(StickerService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Sticker sticker = service.findOne(Long.valueOf(text));
		setValue(sticker);
	}

}
