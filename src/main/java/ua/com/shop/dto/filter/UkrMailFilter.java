package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class UkrMailFilter {

	private String departmentMail = "";

	private List<Long> cityId = new ArrayList<>();

	public String getDepartmentMail() {
		return departmentMail;
	}

	public void setDepartmentMail(String department) {
		this.departmentMail = department;
	}

	public List<Long> getCityId() {
		return cityId;
	}

	public void setCityId(List<Long> cityId) {
		this.cityId = cityId;
	}

}
