package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

	private String name;

	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Commodity> commodity = new ArrayList<>();;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

}
