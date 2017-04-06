package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.CityFilter;
import ua.com.shop.entity.City;
import ua.com.shop.entity.Country;
import ua.com.shop.repository.CityRepository;
import ua.com.shop.repository.CountryRepository;
import ua.com.shop.service.CityService;
import ua.com.shop.specification.CitySpecification;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	public void save(City city) {
		cityRepository.save(city);
	}

	public List<City> findAll() {
		return cityRepository.findAll();
	}

	public City findOne(Long id) {
		return cityRepository.findOne(id);
	}

	public void delete(Long id) {
		cityRepository.delete(id);
	}

	public City findByName(String name) {
		return cityRepository.findByName(name);
	}

	public City findUnique(String name, Country country) {
		return cityRepository.findUnique(name, country.getId());
	}

	@Override
	public Page<City> findAll(CityFilter filter, Pageable pageable) {
		return cityRepository.findAll(new CitySpecification(filter), pageable);
	}

	// public List<City> findByUkMailId(int id) {
	// return cityRepository.findByUkMailId(id);
	// }

	// public City findCityByName(String name) {
	// return cityRepository.findCityByName(name);
	// }
	//
	// public City fetchCityWithUsers(String name) {
	// return cityRepository.fetchCityWithUsers(name);
	// }
	//
	// public void addCountryToCity(int idCountry, int idCity) {
	// Country country = countryRepository.findOne(idCountry);
	// City city = cityRepository.findOne(idCity);
	// city.setCountry(country);
	// cityRepository.save(city);
	// }

}
