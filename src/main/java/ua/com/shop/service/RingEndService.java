package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.RingEnd;

public interface RingEndService {
	void save(RingEnd t);

	List<RingEnd> findAll();

	RingEnd findOne(Long id);

	void delete(Long id);

	RingEnd findByName(String name);

	Page<RingEnd> findAll(SimpleFilter filter, Pageable pageable);
}
