package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "type_sticker")
public class TypeSticker extends AbstractEntity {

	private String name;

	@OneToMany(mappedBy = "typeSticker")
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
