package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.UkrMailFilter;
import ua.com.shop.entity.UkrMail;

public class UkrMailSpecification implements Specification<UkrMail> {

	private final UkrMailFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public UkrMailSpecification(UkrMailFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<UkrMail> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		findByDepertment(root, query);
		findByCity(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

	private void findByCity(Root<UkrMail> root, CriteriaQuery<?> query) {
		if (!filter.getCityId().isEmpty()) {
			predicates.add(root.get("city").in(filter.getCityId()));
		}
	}

	private void findByDepertment(Root<UkrMail> root, CriteriaQuery<?> query) {
		if (!filter.getDepartmentMail().isEmpty()) {
			predicates.add(root.get("department").in(filter.getDepartmentMail()));
		}
	}

	private void fetch(Root<UkrMail> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("city");
		}
	}

}
