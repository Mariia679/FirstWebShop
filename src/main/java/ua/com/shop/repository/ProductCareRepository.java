package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.ProductCare;

public interface ProductCareRepository extends
		JpaRepository<ProductCare, Long>, JpaSpecificationExecutor<ProductCare> {

	ProductCare findByName(String name);

	@Query("SELECT t FROM ProductCare t JOIN t.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<ProductCare> findByUserId(Long id);

	@Query("SELECT c FROM ProductCare c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<ProductCare> findByOrderId(Long userId);
}
