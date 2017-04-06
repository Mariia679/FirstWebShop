package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Shaft;

public interface ShaftService {
	void save(Shaft t);

	List<Shaft> findAll();

	Shaft findOne(Long id);

	void delete(Long id);

	Shaft findByName(String name);

	Page<Shaft> findAll(SimpleFilter filter, Pageable pageable);
}
