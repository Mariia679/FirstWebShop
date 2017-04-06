package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.CityFilter;
import ua.com.shop.entity.City;

public class CitySpecification implements Specification<City> {

	private final CityFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public CitySpecification(CityFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		findByName(root, query);
		findByCountry(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

	private void findByCountry(Root<City> root, CriteriaQuery<?> query) {
		if (!filter.getCountryId().isEmpty()) {
			predicates.add(root.get("country").in(filter.getCountryId()));
		}
	}

	private void findByName(Root<City> root, CriteriaQuery<?> query) {
		if (!filter.getNameCity().isEmpty()) {
			predicates.add(root.get("name").in(filter.getNameCity()));
		}
	}

	private void fetch(Root<City> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("country");
		}

	}

}
