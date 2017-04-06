//package ua.com.shop.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user_city")
//public class UserCity extends AbstractEntity {
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_user")
//	private User user;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_city")
//	private City city;
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}
//
//}
