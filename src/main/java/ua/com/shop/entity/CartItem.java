package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Элемент корзины.
 */
@Entity
@Table(name = "cart_item")
public class CartItem extends AbstractEntity {

	@OneToMany(mappedBy = "cartItem")
	@JsonIgnore
	private List<User> users = new ArrayList<>();

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
	private List<MotherInLaw> motherInLaw = new ArrayList<>();

	@ManyToMany
	private List<ProductCare> productCares = new ArrayList<>();

	@ManyToMany
	private List<Sticker> stickers = new ArrayList<>();

	@Column(name = "count")
	private int count = 0;

	private int allPrice = 0;

	public void deleteAll() {
		Iterator<Sticker> iterSticker = stickers.iterator();
		Iterator<ProductCare> iterProductCare = productCares.iterator();
		Iterator<HoldersChalk> iterHoldersChalk = holdersChalks.iterator();
		Iterator<MotherInLaw> iterMotherInLaw = motherInLaw.iterator();
		Iterator<Glove> iterGlove = gloves.iterator();
		Iterator<Chalk> iterChalk = chalks.iterator();
		Iterator<Tube> iterTube = tubes.iterator();
		Iterator<Commodity> iterCommodity = commodities.iterator();
		while (iterSticker.hasNext()) {
			iterSticker.next();
			iterSticker.remove();
		}
		while (iterCommodity.hasNext()) {
			iterCommodity.next();
			iterCommodity.remove();
		}
		while (iterGlove.hasNext()) {
			iterGlove.next();
			iterGlove.remove();
		}
		while (iterHoldersChalk.hasNext()) {
			iterHoldersChalk.next();
			iterHoldersChalk.remove();
		}
		while (iterMotherInLaw.hasNext()) {
			iterMotherInLaw.next();
			iterMotherInLaw.remove();
		}
		while (iterProductCare.hasNext()) {
			iterProductCare.next();
			iterProductCare.remove();
		}
		while (iterChalk.hasNext()) {
			iterChalk.next();
			iterChalk.remove();
		}
		while (iterTube.hasNext()) {
			iterTube.next();
			iterTube.remove();
		}

		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
		allPrice = 0;
	}

	public void addSticker(Sticker entity) {
		stickers.add(entity);
		allPrice += entity.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteSticker(Sticker entity) {
		Iterator<Sticker> iter = stickers.iterator();
		while (iter.hasNext()) {
			Sticker next = iter.next();
			if (next.equals(entity)) {
				iter.remove();
				allPrice -= entity.getPrice();
				break;
			}
		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addProductCare(ProductCare entity) {
		productCares.add(entity);
		allPrice += entity.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteProductCare(ProductCare entity) {
		Iterator<ProductCare> iter = productCares.iterator();
		while (iter.hasNext()) {
			ProductCare next = iter.next();
			if (next.equals(entity)) {
				iter.remove();
				allPrice -= entity.getPrice();
				break;
			}
		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addMotherInLaw(MotherInLaw entity) {
		motherInLaw.add(entity);
		allPrice += entity.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteMotherInLaw(MotherInLaw entity) {
		Iterator<MotherInLaw> iter = motherInLaw.iterator();
		while (iter.hasNext()) {
			MotherInLaw next = iter.next();
			if (next.equals(entity)) {
				iter.remove();
				allPrice -= entity.getPrice();
				break;
			}

		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addHoldersChalk(HoldersChalk entity) {
		holdersChalks.add(entity);
		allPrice += entity.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteHoldersChalk(HoldersChalk entity) {
		Iterator<HoldersChalk> iter = holdersChalks.iterator();
		while (iter.hasNext()) {
			HoldersChalk next = iter.next();
			if (next.equals(entity)) {
				iter.remove();
				allPrice -= entity.getPrice();
				break;
			}

		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addGlove(Glove entity) {
		gloves.add(entity);
		allPrice += entity.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteGlove(Glove entity) {
		Iterator<Glove> iter = gloves.iterator();
		while (iter.hasNext()) {
			Glove next = iter.next();
			if (next.equals(entity)) {
				iter.remove();
				allPrice -= entity.getPrice();
				break;
			}

		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addChalk(Chalk chalk) {
		chalks.add(chalk);
		allPrice += chalk.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteChalk(Chalk chalk) {
		Iterator<Chalk> iter = chalks.iterator();
		while (iter.hasNext()) {
			Chalk next = iter.next();
			if (next.equals(chalk)) {
				iter.remove();
				allPrice -= chalk.getPrice();
				break;
			}

		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addTube(Tube tube) {
		tubes.add(tube);
		allPrice += tube.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteTube(Tube tube) {
		Iterator<Tube> iter = tubes.iterator();
		while (iter.hasNext()) {
			Tube next = iter.next();
			if (next.equals(tube)) {
				iter.remove();
				allPrice -= tube.getPrice();
				break;
			}

		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void addCommodity(Commodity commodity) {
		commodities.add(commodity);
		allPrice += commodity.getPrice();
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public void deleteCommodity(Commodity commodity) {
		Iterator<Commodity> iter = commodities.iterator();
		while (iter.hasNext()) {
			Commodity next = iter.next();
			if (next.equals(commodity)) {
				iter.remove();
				allPrice -= commodity.getPrice();
				break;
			}

		}
		count = commodities.size() + tubes.size() + chalks.size()
				+ gloves.size() + holdersChalks.size() + motherInLaw.size()
				+ productCares.size() + stickers.size();
	}

	public List<Tube> getTubes() {
		return tubes;
	}

	public void setTubes(List<Tube> tubes) {
		this.tubes = tubes;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Commodity> getCommodity() {
		return commodities;
	}

	public void setCommodity(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public int getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(int allPrice) {
		this.allPrice = allPrice;
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

	public List<MotherInLaw> getMotherInLaw() {
		return motherInLaw;
	}

	public void setMotherInLaw(List<MotherInLaw> motherInLaw) {
		this.motherInLaw = motherInLaw;
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
