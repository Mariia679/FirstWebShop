package ua.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ukr_mail", indexes = { @Index(columnList = "department") })
public class UkrMail extends AbstractEntity {

	private String department;

	@ManyToOne(fetch = FetchType.LAZY)
	private City city;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
