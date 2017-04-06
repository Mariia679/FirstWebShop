package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Country;

public interface CountryService {

	void save(Country t);

	List<Country> findAll();

	Country findOne(Long id);

	void delete(Long id);

	Country findByName(String name);

	Page<Country> findAll(SimpleFilter filter, Pageable pageable);

}
