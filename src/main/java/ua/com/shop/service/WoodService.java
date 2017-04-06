package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Wood;

public interface WoodService {
	void save(Wood t);

	List<Wood> findAll();

	Wood findOne(Long id);

	void delete(Long id);

	Wood findByName(String name);

	Page<Wood> findAll(SimpleFilter filter, Pageable pageable);
}
