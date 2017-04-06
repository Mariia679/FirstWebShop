package ua.com.shop.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Butt;
import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Damper;
import ua.com.shop.entity.Ferula;
import ua.com.shop.entity.GashType;
import ua.com.shop.entity.MainMaterial;
import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.entity.RingBumper;
import ua.com.shop.entity.RingEnd;
import ua.com.shop.entity.Shaft;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.TypeSticker;
import ua.com.shop.entity.Wood;

public class CommodityForm {

	private Long id;

	private String name;

	private String price;

	private String length;

	private String weight;

	private String description;

	private Category category;

	private MainMaterial mainMaterial;

	private Wood wood;

	private Ferula ferula;

	private GashType gashType;

	private Shaft shaft;

	private Butt butt;

	private Sticker sticker;

	private TypeSticker typeSticker;

	private RingEnd ringEnd;

	private RingBumper ringBumper;

	private Damper damper;

	private CarvingJoint carvingJoint;

	private MaterialJoint materialJoint;

	private MultipartFile file;

	private int version;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
