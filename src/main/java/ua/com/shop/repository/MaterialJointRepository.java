package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.MaterialJoint;

public interface MaterialJointRepository extends
		JpaRepository<MaterialJoint, Long>,
		JpaSpecificationExecutor<MaterialJoint> {

	MaterialJoint findByName(String name);

}
