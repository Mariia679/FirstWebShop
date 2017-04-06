package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;

public interface CategoryService {

	void save(Category t);

	List<Category> findAll();

	Category findOne(Long id);

	void delete(Long id);

	Category findByName(String name);

	Page<Category> findAll(SimpleFilter filter, Pageable pageable);
}
