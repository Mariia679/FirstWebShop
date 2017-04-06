package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.GashType;

public interface GashTypeRepository extends JpaRepository<GashType, Long>,
		JpaSpecificationExecutor<GashType> {

	GashType findByName(String name);

}
