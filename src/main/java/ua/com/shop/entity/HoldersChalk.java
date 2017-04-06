package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "holders_chalk")
public class HoldersChalk extends AbstractEntity {

	private String name;

	private int price;

	@Column(name = "description", length = 2500)
	private String description;

	@Transient
	private MultipartFile file;

	private int version;

	@ManyToMany(mappedBy = "holdersChalks")
	@JsonIgnore
	private List<CartItem> cartItems = new ArrayList<>();

	@ManyToMany(mappedBy = "holdersChalks")
	@JsonIgnore
	private List<Order> order = new ArrayList<>();

	@OneToMany(mappedBy = "holdersChalk")
	@JsonIgnore
	private List<Reviews> reviews = new ArrayList<>();

	private Long quantity;

	private Long sumPrice;

	public HoldersChalk() {
	}

	public HoldersChalk(Long id, String name, Long count, Long allPrice,
			int price, int version) {
		setId(id);
		this.name = name;
		this.sumPrice = allPrice;
		this.price = price;
		this.version = version;
		this.quantity = count;
	}

	public Long getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
