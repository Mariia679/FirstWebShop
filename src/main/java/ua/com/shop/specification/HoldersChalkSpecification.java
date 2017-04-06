package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.HoldersChalkFilter;
import ua.com.shop.entity.HoldersChalk;

public class HoldersChalkSpecification implements Specification<HoldersChalk> {

	private final HoldersChalkFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	public HoldersChalkSpecification(HoldersChalkFilter filter) {
		this.filter = filter;
		if (REG.matcher(filter.getMax()).matches()) {
			filter.setMaxValue(new Integer(filter.getMax()));
		}
		if (REG.matcher(filter.getMin()).matches()) {
			filter.setMinValue(new Integer(filter.getMin()));
		}
	}

	@Override
	public Predicate toPredicate(Root<HoldersChalk> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		findByPrice(root, query, cb);
		findByName(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

	private void findByPrice(Root<HoldersChalk> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMaxValue() != null) {
			predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
		}
		if (filter.getMinValue() != null) {
			predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
		}
	}

	private void findByName(Root<HoldersChalk> root, CriteriaQuery<?> query) {
		if (!filter.getNameHoldersChalk().isEmpty()) {
			predicates.add(root.get("name").in(filter.getNameHoldersChalk()));
		}
	}

}
