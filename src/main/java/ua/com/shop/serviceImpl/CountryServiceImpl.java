package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Country;
import ua.com.shop.repository.CityRepository;
import ua.com.shop.repository.CountryRepository;
import ua.com.shop.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	public Country findOne(Long id) {
		return countryRepository.findOne(id);
	}

	public void delete(Long id) {
		countryRepository.delete(id);

	}

	public void save(Country t) {
		countryRepository.save(t);
	}

	public Country findByName(String name) {
		return countryRepository.findByName(name);
	}

	@Override
	public Page<Country> findAll(SimpleFilter filter, Pageable pageable) {
		return countryRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Country> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

}
