package ua.com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MainPage extends AbstractEntity {

	// @Lob
	// @Basic(fetch = FetchType.LAZY)
	@Column(name = "content", length = 2500)
	private String content;

	private String name;

	public String getContent() {
		return content;
	}

	public void setContent(String bs) {
		this.content = bs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
