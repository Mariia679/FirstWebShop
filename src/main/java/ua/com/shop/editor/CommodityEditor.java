package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Commodity;
import ua.com.shop.service.CommodityService;

public class CommodityEditor extends PropertyEditorSupport {

	private final CommodityService service;

	public CommodityEditor(CommodityService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Commodity commodity = service.findOne(Long.valueOf(text));
		setValue(commodity);
	}
}
