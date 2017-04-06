package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Ferula;

public interface FerulaRepository extends JpaRepository<Ferula, Long>,
		JpaSpecificationExecutor<Ferula> {

	Ferula findByName(String name);

}
