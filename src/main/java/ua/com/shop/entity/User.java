package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "_user", indexes = @Index(columnList = "username"))
public class User extends AbstractEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2048537316822556266L;

	private String name;

	private String surname;

	private String email;

	private String password;

	private String phone;

	private String username;
	@Enumerated
	@Column(name = "_role")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	private MethodDelivery methodDelivery;

	@ManyToOne(fetch = FetchType.LAZY)
	private NewMail newMail;

	private String mail;

	// @OneToMany(mappedBy = "user")
	// @JsonIgnore
	// private List<UserCity> userCities = new ArrayList<>();;

	@ManyToOne(fetch = FetchType.LAZY)
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	private CartItem cartItem;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Reviews> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Order> orders = new ArrayList<>();

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MethodDelivery getMethodDelivery() {
		return methodDelivery;
	}

	public void setMethodDelivery(MethodDelivery methodDelivery) {
		this.methodDelivery = methodDelivery;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(role.name()));
		return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public NewMail getNewMail() {
		return newMail;
	}

	public void setNewMail(NewMail newMail) {
		this.newMail = newMail;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
