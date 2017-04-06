package ua.com.shop.dto.cart;

public class Quantity {

	private Long count;

	public Quantity(Long count) {
		this.count = count;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}