package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.MainMaterial;

public interface MainMaterialRepository extends
		JpaRepository<MainMaterial, Long>,
		JpaSpecificationExecutor<MainMaterial> {

	MainMaterial findByName(String name);

}
