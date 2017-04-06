package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "new_mail", indexes = { @Index(columnList = "department") })
public class NewMail extends AbstractEntity {

	private String department;

	@ManyToOne(fetch = FetchType.LAZY)
	private City city;

	@OneToMany(mappedBy = "newMail")
	private List<User> users;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
