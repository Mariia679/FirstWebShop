package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.GashType;

public interface GashTypeService {

	void save(GashType t);

	List<GashType> findAll();

	GashType findOne(Long id);

	void delete(Long id);

	GashType findByName(String name);

	Page<GashType> findAll(SimpleFilter filter, Pageable pageable);
}
