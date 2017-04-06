package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.ProductDescription;

public interface ProductDescriptionRepository extends
		JpaRepository<ProductDescription, Long>,
		JpaSpecificationExecutor<ProductDescription> {

	@Query("SELECT p FROM ProductDescription p LEFT JOIN FETCH p.commodity WHERE p.id=?1")
	ProductDescription findOne(Long id);

	@Query("SELECT p FROM ProductDescription p LEFT JOIN FETCH p.commodity")
	List<ProductDescription> findAll();

}
