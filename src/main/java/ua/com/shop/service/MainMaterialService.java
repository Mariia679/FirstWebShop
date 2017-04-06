package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MainMaterial;

public interface MainMaterialService {
	
	void save(MainMaterial t);

	List<MainMaterial> findAll();

	MainMaterial findOne(Long id);

	void delete(Long id);

	MainMaterial findByName(String name);

	Page<MainMaterial> findAll(SimpleFilter filter, Pageable pageable);
}
