package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Damper;

public interface DamperRepository extends JpaRepository<Damper, Long>,
		JpaSpecificationExecutor<Damper> {

	Damper findByName(String name);

}
