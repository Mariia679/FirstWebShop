package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.entity.Commodity;

public class CommoditySpecification implements Specification<Commodity> {

	private final CommodityFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	public CommoditySpecification(CommodityFilter filter) {
		this.filter = filter;
		if (REG.matcher(filter.getMax()).matches()) {
			filter.setMaxValue(new Integer(filter.getMax()));
		}
		if (REG.matcher(filter.getMin()).matches()) {
			filter.setMinValue(new Integer(filter.getMin()));
		}
	}

	private void findByFerula(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getFerulaId().isEmpty()) {
			predicates.add(root.get("ferula").in(filter.getFerulaId()));
		}
	}

	private void findByName(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getNameCommodity().isEmpty()) {
			predicates.add(root.get("name").in(filter.getNameCommodity()));
		}
	}

	private void findByWood(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getWoodId().isEmpty()) {
			predicates.add(root.get("wood").in(filter.getWoodId()));
		}
	}

	private void findByMainMaterial(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getMainMaterialId().isEmpty()) {
			predicates.add(root.get("mainMaterial").in(
					filter.getMainMaterialId()));
		}
	}

	private void findByCategory(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getCategoryId().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryId()));
		}
	}

	private void findByPrice(Root<Commodity> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMaxValue() != null) {
			predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
		}
		if (filter.getMinValue() != null) {
			predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
		}
	}

	private void fetch(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("category");
			root.fetch("mainMaterial");
			root.fetch("wood");
			root.fetch("ferula");
			root.fetch("gashType");
			root.fetch("shaft");
			root.fetch("butt");
			root.fetch("sticker");
			root.fetch("typeSticker");
			root.fetch("ringEnd");
			root.fetch("ringBumper");
			root.fetch("damper");
			root.fetch("carvingJoint");
			root.fetch("materialJoint");

		}
	}

	@Override
	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		findByPrice(root, query, cb);
		findByCategory(root, query);
		findByMainMaterial(root, query);
		findByWood(root, query);
		findByFerula(root, query);
		findByGashType(root, query);
		findByShaft(root, query);
		findByButt(root, query);
		findBySticker(root, query);
		findByTypeSticker(root, query);
		findByRingEnd(root, query);
		findByRingBumper(root, query);
		findByDamper(root, query);
		findByCarvingJoint(root, query);
		findByMaterialJoint(root, query);
		findByLength(root, query);
		findByWeight(root, query);
		findByName(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

	private void findByWeight(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getWeightCue().isEmpty()) {
			predicates.add(root.get("weight").in(filter.getWeightCue()));
		}
	}

	private void findByLength(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getLengthCue().isEmpty()) {
			predicates.add(root.get("length").in(filter.getLengthCue()));
		}
	}

	private void findByMaterialJoint(Root<Commodity> root,
			CriteriaQuery<?> query) {
		if (!filter.getMaterialJointId().isEmpty()) {
			predicates.add(root.get("materialJoint").in(
					filter.getMaterialJointId()));
		}
	}

	private void findByCarvingJoint(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getCarvingJointId().isEmpty()) {
			predicates.add(root.get("carvingJoint").in(
					filter.getCarvingJointId()));
		}
	}

	private void findByDamper(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getDamperId().isEmpty()) {
			predicates.add(root.get("damper").in(filter.getDamperId()));
		}
	}

	private void findByRingBumper(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getRingBumperId().isEmpty()) {
			predicates.add(root.get("ringBumper").in(filter.getRingBumperId()));
		}
	}

	private void findByRingEnd(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getRingEndId().isEmpty()) {
			predicates.add(root.get("ringEnd").in(filter.getRingEndId()));
		}
	}

	private void findByTypeSticker(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getTypeStickerId().isEmpty()) {
			predicates.add(root.get("typeSticker")
					.in(filter.getTypeStickerId()));
		}
	}

	private void findBySticker(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getStickerId().isEmpty()) {
			predicates.add(root.get("sticker").in(filter.getStickerId()));
		}
	}

	private void findByButt(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getButtId().isEmpty()) {
			predicates.add(root.get("butt").in(filter.getButtId()));
		}
	}

	private void findByShaft(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getShaftId().isEmpty()) {
			predicates.add(root.get("shaft").in(filter.getShaftId()));
		}
	}

	private void findByGashType(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getGashTypeId().isEmpty()) {
			predicates.add(root.get("gashType").in(filter.getGashTypeId()));
		}
	}

}
