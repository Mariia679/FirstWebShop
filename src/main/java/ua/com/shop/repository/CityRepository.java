package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.City;

public interface CityRepository extends JpaRepository<City, Long>,
		JpaSpecificationExecutor<City> {

	// @Query("select c from City c where name=:param")
	// City findCityByName(@Param("param") String name);
	//
	// @Query("select c from City c right join fetch c.users where c.name=:param")
	// City fetchCityWithUsers(@Param("param") String name);

	@Query("SELECT a FROM City a LEFT JOIN FETCH a.country WHERE a.id=?1")
	City findOne(Long id);

	@Query("SELECT a FROM City a LEFT JOIN FETCH a.country")
	List<City> findAll();

	City findByName(String name);

	@Query("SELECT c FROM City c WHERE c.name=?1 and c.country.id=?2")
	City findUnique(String name, Long long1);

	// @Query("UPDATE City SET City.ukrMails='NULL' WHERE ;")
	// List<City> findByUkMailId(int id);

}
