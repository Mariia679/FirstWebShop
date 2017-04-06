package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.MethodDelivery;

public interface MethodDeliveryRepository extends
		JpaRepository<MethodDelivery, Long>,
		JpaSpecificationExecutor<MethodDelivery> {

	MethodDelivery findByTitle(String title);

}
