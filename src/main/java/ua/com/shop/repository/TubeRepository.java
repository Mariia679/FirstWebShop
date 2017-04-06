package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Tube;

public interface TubeRepository extends JpaRepository<Tube, Long>,
		JpaSpecificationExecutor<Tube> {

	Tube findByName(String name);
	
	@Query("SELECT t FROM Tube t JOIN t.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<Tube> findByUserId(Long userId);
	
	@Query("SELECT c FROM Tube c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<Tube> findByOrderId(Long userId);
}
