package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Ferula;

public interface FerulaService {
	void save(Ferula t);

	List<Ferula> findAll();

	Ferula findOne(Long id);

	void delete(Long id);

	Ferula findByName(String name);

	Page<Ferula> findAll(SimpleFilter filter, Pageable pageable);
}
