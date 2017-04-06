package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Wood;

public interface WoodRepository extends JpaRepository<Wood, Long>,
		JpaSpecificationExecutor<Wood> {

	Wood findByName(String name);

}
