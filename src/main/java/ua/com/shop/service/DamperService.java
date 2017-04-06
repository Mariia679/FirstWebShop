package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Damper;

public interface DamperService {

	void save(Damper t);

	List<Damper> findAll();

	Damper findOne(Long id);

	void delete(Long id);

	Damper findByName(String name);

	Page<Damper> findAll(SimpleFilter filter, Pageable pageable);
}
