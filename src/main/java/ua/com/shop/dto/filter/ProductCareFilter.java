package ua.com.shop.dto.filter;

public class ProductCareFilter {

	private String min = "";

	private String max = "";

	private Integer minValue;

	private Integer maxValue;

	private String nameProductCare = "";

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public String getNameProductCare() {
		return nameProductCare;
	}

	public void setNameProductCare(String nameProductCare) {
		this.nameProductCare = nameProductCare;
	}

}
