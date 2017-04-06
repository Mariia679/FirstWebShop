package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wood", indexes = { @Index(columnList = "name") })
public class Wood extends AbstractEntity {

	private String name;

	@OneToMany(mappedBy = "wood")
	@JsonIgnore
	private List<Commodity> commodities = new ArrayList<>();;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commodity> getCommodity() {
		return commodities;
	}

	public void setCommodity(List<Commodity> commodities) {
		this.commodities = commodities;
	}

}
