package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.MotherInLaw;

public interface MotherInLawRepository extends
		JpaRepository<MotherInLaw, Long>, JpaSpecificationExecutor<MotherInLaw> {

	MotherInLaw findByName(String name);

	@Query("SELECT t FROM MotherInLaw t JOIN t.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<MotherInLaw> findByUserId(Long id);
	
	@Query("SELECT c FROM MotherInLaw c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<MotherInLaw> findByOrderId(Long userId);
}
