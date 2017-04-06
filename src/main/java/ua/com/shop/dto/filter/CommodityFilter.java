package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class CommodityFilter {

	private String min = "";

	private String max = "";

	private Integer minValue;

	private Integer maxValue;

	private String nameCommodity = "";

	private String lengthCue = "";

	private String weightCue = "";

	private List<Long> categoryId = new ArrayList<>();

	private List<Long> mainMaterialId = new ArrayList<>();

	private List<Long> woodId = new ArrayList<>();

	private List<Long> ferulaId = new ArrayList<>();

	private List<Long> gashTypeId = new ArrayList<>();

	private List<Long> shaftId = new ArrayList<>();

	private List<Long> buttId = new ArrayList<>();

	private List<Long> stickerId = new ArrayList<>();

	private List<Long> typeStickerId = new ArrayList<>();

	private List<Long> ringEndId = new ArrayList<>();

	private List<Long> ringBumperId = new ArrayList<>();

	private List<Long> damperId = new ArrayList<>();

	private List<Long> carvingJointId = new ArrayList<>();

	private List<Long> materialJointId = new ArrayList<>();

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public String getNameCommodity() {
		return nameCommodity;
	}

	public void setNameCommodity(String nameCommodity) {
		this.nameCommodity = nameCommodity;
	}

	public String getLengthCue() {
		return lengthCue;
	}

	public void setLengthCue(String lengthCue) {
		this.lengthCue = lengthCue;
	}

	public String getWeightCue() {
		return weightCue;
	}

	public void setWeightCue(String weightCue) {
		this.weightCue = weightCue;
	}

	public List<Long> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Long> categoryId) {
		this.categoryId = categoryId;
	}

	public List<Long> getMainMaterialId() {
		return mainMaterialId;
	}

	public void setMainMaterialId(List<Long> mainMaterialId) {
		this.mainMaterialId = mainMaterialId;
	}

	public List<Long> getWoodId() {
		return woodId;
	}

	public void setWoodId(List<Long> woodId) {
		this.woodId = woodId;
	}

	public List<Long> getFerulaId() {
		return ferulaId;
	}

	public void setFerulaId(List<Long> ferulaId) {
		this.ferulaId = ferulaId;
	}

	public List<Long> getGashTypeId() {
		return gashTypeId;
	}

	public void setGashTypeId(List<Long> gashTypeId) {
		this.gashTypeId = gashTypeId;
	}

	public List<Long> getShaftId() {
		return shaftId;
	}

	public void setShaftId(List<Long> shaftId) {
		this.shaftId = shaftId;
	}

	public List<Long> getButtId() {
		return buttId;
	}

	public void setButtId(List<Long> buttId) {
		this.buttId = buttId;
	}

	public List<Long> getStickerId() {
		return stickerId;
	}

	public void setStickerId(List<Long> stickerId) {
		this.stickerId = stickerId;
	}

	public List<Long> getTypeStickerId() {
		return typeStickerId;
	}

	public void setTypeStickerId(List<Long> typeStickerId) {
		this.typeStickerId = typeStickerId;
	}

	public List<Long> getRingEndId() {
		return ringEndId;
	}

	public void setRingEndId(List<Long> ringEndId) {
		this.ringEndId = ringEndId;
	}

	public List<Long> getRingBumperId() {
		return ringBumperId;
	}

	public void setRingBumperId(List<Long> ringBumperId) {
		this.ringBumperId = ringBumperId;
	}

	public List<Long> getDamperId() {
		return damperId;
	}

	public void setDamperId(List<Long> damperId) {
		this.damperId = damperId;
	}

	public List<Long> getCarvingJointId() {
		return carvingJointId;
	}

	public void setCarvingJointId(List<Long> carvingJointId) {
		this.carvingJointId = carvingJointId;
	}

	public List<Long> getMaterialJointId() {
		return materialJointId;
	}

	public void setMaterialJointId(List<Long> materialJointId) {
		this.materialJointId = materialJointId;
	}

}
