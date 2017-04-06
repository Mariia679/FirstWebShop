package ua.com.shop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Reviews extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	private Commodity commodity;

	@ManyToOne(fetch = FetchType.LAZY)
	private Tube tube;

	@ManyToOne(fetch = FetchType.LAZY)
	private Chalk chalk;

	@ManyToOne(fetch = FetchType.LAZY)
	private Glove glove;

	@ManyToOne(fetch = FetchType.LAZY)
	private HoldersChalk holdersChalk;

	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCare productCare;

	@ManyToOne(fetch = FetchType.LAZY)
	private Sticker sticker;

	@ManyToOne(fetch = FetchType.LAZY)
	private MotherInLaw motherInLaw;

	private Date date;

	@Column(name = "review", length = 3000)
	private String review;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Chalk getChalk() {
		return chalk;
	}

	public void setChalk(Chalk chalk) {
		this.chalk = chalk;
	}

	public Glove getGlove() {
		return glove;
	}

	public void setGlove(Glove glove) {
		this.glove = glove;
	}

	public HoldersChalk getHoldersChalk() {
		return holdersChalk;
	}

	public void setHoldersChalk(HoldersChalk holdersChalk) {
		this.holdersChalk = holdersChalk;
	}

	public ProductCare getProductCare() {
		return productCare;
	}

	public void setProductCare(ProductCare productCare) {
		this.productCare = productCare;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public void setSticker(Sticker sticker) {
		this.sticker = sticker;
	}

	public Tube getTube() {
		return tube;
	}

	public void setTube(Tube tube) {
		this.tube = tube;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MotherInLaw getMotherInLaw() {
		return motherInLaw;
	}

	public void setMotherInLaw(MotherInLaw motherInLaw) {
		this.motherInLaw = motherInLaw;
	}

}
