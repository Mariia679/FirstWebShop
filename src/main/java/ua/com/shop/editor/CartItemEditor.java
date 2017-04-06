package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.CartItem;
import ua.com.shop.service.CartItemService;

public class CartItemEditor extends PropertyEditorSupport {

	private final CartItemService service;

	public CartItemEditor(CartItemService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		CartItem cart = service.findOne(Long.valueOf(text));
		setValue(cart);
	}
}
