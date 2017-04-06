package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.CityFilter;
import ua.com.shop.entity.City;
import ua.com.shop.entity.Country;

public interface CityService {

	void save(City city);

	List<City> findAll();

	City findOne(Long id);

	void delete(Long id);

	City findByName(String name);

	City findUnique(String name, Country country);

	Page<City> findAll(CityFilter filter, Pageable pageable);

	// List<City> findByUkMailId(int id);

	// City findCityByName(String name);
	//
	// City fetchCityWithUsers(String name);
	//
	// void addCountryToCity(int idCountry, int idCity);
}
