package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "_order")
public class Order extends AbstractEntity {

	@ManyToMany
	private List<Commodity> commodities = new ArrayList<>();

	@ManyToMany
	private List<Tube> tubes = new ArrayList<>();

	@ManyToMany
	private List<Chalk> chalks = new ArrayList<>();

	@ManyToMany
	private List<Glove> gloves = new ArrayList<>();

	@ManyToMany
	private List<HoldersChalk> holdersChalks = new ArrayList<>();

	@ManyToMany
	private List<MotherInLaw> motherInLaws = new ArrayList<>();

	@ManyToMany
	private List<ProductCare> productCares = new ArrayList<>();

	@ManyToMany
	private List<Sticker> stickers = new ArrayList<>();

	@ManyToOne
	private User user;;

	private boolean status = false;

	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Tube> getTubes() {
		return tubes;
	}

	public void setTubes(List<Tube> tubes) {
		this.tubes = tubes;
	}

	public List<Chalk> getChalks() {
		return chalks;
	}

	public void setChalks(List<Chalk> chalks) {
		this.chalks = chalks;
	}

	public List<Glove> getGloves() {
		return gloves;
	}

	public void setGloves(List<Glove> gloves) {
		this.gloves = gloves;
	}

	public List<HoldersChalk> getHoldersChalks() {
		return holdersChalks;
	}

	public void setHoldersChalks(List<HoldersChalk> holdersChalks) {
		this.holdersChalks = holdersChalks;
	}

	public List<MotherInLaw> getMotherInLaws() {
		return motherInLaws;
	}

	public void setMotherInLaws(List<MotherInLaw> motherInLaws) {
		this.motherInLaws = motherInLaws;
	}

	public List<ProductCare> getProductCares() {
		return productCares;
	}

	public void setProductCares(List<ProductCare> productCares) {
		this.productCares = productCares;
	}

	public List<Sticker> getStickers() {
		return stickers;
	}

	public void setStickers(List<Sticker> stickers) {
		this.stickers = stickers;
	}

}
