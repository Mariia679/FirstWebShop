package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.RingBumper;

public interface RingBumperRepository extends
		JpaRepository<RingBumper, Long>,
		JpaSpecificationExecutor<RingBumper> {

	RingBumper findByName(String name);

}
