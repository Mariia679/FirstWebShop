package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Butt;

public interface ButtRepository extends JpaRepository<Butt, Long>,
		JpaSpecificationExecutor<Butt> {

	Butt findByName(String name);

	// @Query("select b from Butt b where name=:param")
	// Butt findButtByName(@Param("param") String name);

	// @Query(value = "SELECT b FROM Butt b", countQuery =
	// "SELECT count(b.id) FROM Butt b")
	// Page<Butt> findAll(Pageable pageable);

}
