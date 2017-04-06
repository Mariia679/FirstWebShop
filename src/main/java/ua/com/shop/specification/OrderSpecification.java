package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.OrderFilter;
import ua.com.shop.entity.Order;

public class OrderSpecification implements Specification<Order> {

	private final OrderFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public OrderSpecification(OrderFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		findByCart(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

	private void findByCart(Root<Order> root, CriteriaQuery<?> query) {
		if (!filter.getCartId().isEmpty()) {
			predicates.add(root.get("cartItem").in(filter.getCartId()));
		}
	}

	private void fetch(Root<Order> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("cartItem");
		}

	}
}
