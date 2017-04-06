package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.NewMailFilter;
import ua.com.shop.entity.NewMail;

public class NewMailSpecification implements Specification<NewMail> {

	private final NewMailFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public NewMailSpecification(NewMailFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<NewMail> root, CriteriaQuery<?> query,
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

	private void findByCity(Root<NewMail> root, CriteriaQuery<?> query) {
		if (!filter.getCityId().isEmpty()) {
			predicates.add(root.get("city").in(filter.getCityId()));
		}
	}

	private void findByDepertment(Root<NewMail> root, CriteriaQuery<?> query) {
		if (!filter.getDepartmentMail().isEmpty()) {
			predicates.add(root.get("department")
					.in(filter.getDepartmentMail()));
		}
	}

	private void fetch(Root<NewMail> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("city");
		}
	}

}
