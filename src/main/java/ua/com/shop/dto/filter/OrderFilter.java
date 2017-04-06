package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class OrderFilter {
	private List<Long> cartId = new ArrayList<>();

	public List<Long> getCartId() {
		return cartId;
	}

	public void setCartId(List<Long> cartId) {
		this.cartId = cartId;
	}

}
