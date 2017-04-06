package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>,
		JpaSpecificationExecutor<Country> {

	Country findByName(String name);

	// @Query("SELECT c FROM City c WHERE c.country.id=?1")
	// List<City> deleteCityFromCountry(Integer countryId);

}
