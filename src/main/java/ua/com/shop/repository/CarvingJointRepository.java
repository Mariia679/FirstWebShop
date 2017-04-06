package ua.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.CarvingJoint;

public interface CarvingJointRepository extends
		JpaRepository<CarvingJoint, Long>,
		JpaSpecificationExecutor<CarvingJoint> {

	CarvingJoint findByName(String name);

}
