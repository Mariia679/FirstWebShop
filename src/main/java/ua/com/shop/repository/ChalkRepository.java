package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;

public interface ChalkRepository extends JpaRepository<Chalk, Long>,
		JpaSpecificationExecutor<Chalk> {

	Chalk findByName(String name);

	@Query("SELECT c FROM Chalk c JOIN c.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<Chalk> findByUserId(Long id);
	
	@Query("SELECT c FROM Chalk c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<Chalk> findByOrderId(Long userId);

}
