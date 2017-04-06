package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Shaft;

public interface ShaftRepository extends JpaRepository<Shaft, Long>,
		JpaSpecificationExecutor<Shaft> {

	Shaft findByName(String name);

}
