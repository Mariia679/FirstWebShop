package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city", indexes = { @Index(columnList = "name") })
public class City extends AbstractEntity {

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;

	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private List<User> users = new ArrayList<>();;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<NewMail> newMails = new ArrayList<>();;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<UkrMail> ukrMails = new ArrayList<>();;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<NewMail> getNewMails() {
		return newMails;
	}

	public void setNewMails(List<NewMail> newMails) {
		this.newMails = newMails;
	}

	public List<UkrMail> getUkrMails() {
		return ukrMails;
	}

	public void setUkrMails(List<UkrMail> ukrMails) {
		this.ukrMails = ukrMails;
	}

}
