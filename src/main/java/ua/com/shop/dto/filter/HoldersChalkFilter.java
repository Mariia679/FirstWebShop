package ua.com.shop.dto.filter;

public class HoldersChalkFilter {

	private String min = "";

	private String max = "";

	private Integer minValue;

	private Integer maxValue;

	private String nameHoldersChalk = "";

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

	public String getNameHoldersChalk() {
		return nameHoldersChalk;
	}

	public void setNameHoldersChalk(String nameHoldersChalk) {
		this.nameHoldersChalk = nameHoldersChalk;
	}

}
