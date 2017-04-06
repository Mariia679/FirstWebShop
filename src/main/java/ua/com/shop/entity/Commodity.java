package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "main", indexes = {
		@Index(columnList = "name,price,length,weight"),
		@Index(columnList = "name"), @Index(columnList = "price"),
		@Index(columnList = "length"), @Index(columnList = "weight") })
public class Commodity extends AbstractEntity {

	private String name;

	private int price;

	private String length;

	private String weight;

	@Transient
	private MultipartFile file;

	private int version;
	@NotNull
	private int count = 0;

	@Column(name = "description", length = 2500)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_main_material")
	private MainMaterial mainMaterial;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_wood")
	private Wood wood;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ferula")
	private Ferula ferula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gash_type")
	private GashType gashType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shaft")
	private Shaft shaft;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_butt")
	private Butt butt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sticker")
	private Sticker sticker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_sticker")
	private TypeSticker typeSticker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ring_end")
	private RingEnd ringEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ring_bumper")
	private RingBumper ringBumper;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_damper")
	private Damper damper;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_carving_joint")
	private CarvingJoint carvingJoint;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_material_joint")
	private MaterialJoint materialJoint;

	@ManyToMany(mappedBy = "commodities")
	@JsonIgnore
	private List<CartItem> cartItems = new ArrayList<>();

	@ManyToMany(mappedBy = "commodities")
	@JsonIgnore
	private List<Order> order = new ArrayList<>();

	@OneToMany(mappedBy = "commodity")
	@JsonIgnore
	private List<ProductDescription> productDescription = new ArrayList<>();

	@OneToMany(mappedBy = "commodity")
	@JsonIgnore
	private List<Reviews> reviews = new ArrayList<>();

	public Commodity() {
	}

	private Long quantity;

	private Long sumPrice;

	public Commodity(Long id, String name, Long count, Long allPrice,
			int price, int version) {
		setId(id);
		this.name = name;
		this.sumPrice = allPrice;
		this.price = price;
		this.version = version;
		this.quantity = count;

	}

	public int addCount() {
		return ++count;
	}

	public Long getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<ProductDescription> getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(
			List<ProductDescription> productDescription) {
		this.productDescription = productDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public MainMaterial getMainMaterial() {
		return mainMaterial;
	}

	public void setMainMaterial(MainMaterial mainMaterial) {
		this.mainMaterial = mainMaterial;
	}

	public Wood getWood() {
		return wood;
	}

	public void setWood(Wood wood) {
		this.wood = wood;
	}

	public Ferula getFerula() {
		return ferula;
	}

	public void setFerula(Ferula ferula) {
		this.ferula = ferula;
	}

	public GashType getGashType() {
		return gashType;
	}

	public void setGashType(GashType gashType) {
		this.gashType = gashType;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public void setSticker(Sticker sticker) {
		this.sticker = sticker;
	}

	public TypeSticker getTypeSticker() {
		return typeSticker;
	}

	public void setTypeSticker(TypeSticker typeSticker) {
		this.typeSticker = typeSticker;
	}

	public RingEnd getRingEnd() {
		return ringEnd;
	}

	public void setRingEnd(RingEnd ringEnd) {
		this.ringEnd = ringEnd;
	}

	public RingBumper getRingBumper() {
		return ringBumper;
	}

	public void setRingBumper(RingBumper ringBumper) {
		this.ringBumper = ringBumper;
	}

	public Damper getDamper() {
		return damper;
	}

	public void setDamper(Damper damper) {
		this.damper = damper;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Shaft getShaft() {
		return shaft;
	}

	public void setShaft(Shaft shaft) {
		this.shaft = shaft;
	}

	public Butt getButt() {
		return butt;
	}

	public void setButt(Butt butt) {
		this.butt = butt;
	}

	public CarvingJoint getCarvingJoint() {
		return carvingJoint;
	}

	public void setCarvingJoint(CarvingJoint carvingJoint) {
		this.carvingJoint = carvingJoint;
	}

	public MaterialJoint getMaterialJoint() {
		return materialJoint;
	}

	public void setMaterialJoint(MaterialJoint materialJoint) {
		this.materialJoint = materialJoint;
	}

	public List<CartItem> getCartItem() {
		return cartItems;
	}

	public void setCartItem(List<CartItem> cartItems) {
		this.cartItems = cartItems;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
