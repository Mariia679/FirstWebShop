package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "country", indexes = { @Index(columnList = "name") })
public class Country extends AbstractEntity {

	private String name;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<City> cities = new ArrayList<>();;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
