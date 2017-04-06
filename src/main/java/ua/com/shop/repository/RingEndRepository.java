package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.RingEnd;

public interface RingEndRepository extends JpaRepository<RingEnd, Long>,
		JpaSpecificationExecutor<RingEnd> {

	RingEnd findByName(String name);

}
