package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;

public interface GloveRepository extends JpaRepository<Glove, Long>,
		JpaSpecificationExecutor<Glove> {

	Glove findByName(String name);

	@Query("SELECT g FROM Glove g JOIN g.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<Glove> findByUserId(Long id);
	
	@Query("SELECT c FROM Glove c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<Glove> findByOrderId(Long userId);
}
