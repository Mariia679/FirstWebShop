package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.HoldersChalk;

public interface HoldersChalkRepository extends
		JpaRepository<HoldersChalk, Long>,
		JpaSpecificationExecutor<HoldersChalk> {

	HoldersChalk findByName(String name);

	@Query("SELECT c FROM HoldersChalk c JOIN c.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<HoldersChalk> findByUserId(Long id);
	
	@Query("SELECT c FROM HoldersChalk c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<HoldersChalk> findByOrderId(Long userId);
}
