package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class CityFilter{

	private String nameCity = "";

	private List<Long> countryId = new ArrayList<>();

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public List<Long> getCountryId() {
		return countryId;
	}

	public void setCountryId(List<Long> countryId) {
		this.countryId = countryId;
	}

}
