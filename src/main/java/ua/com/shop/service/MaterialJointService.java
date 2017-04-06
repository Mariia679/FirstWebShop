package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MaterialJoint;

public interface MaterialJointService {
	void save(MaterialJoint t);

	List<MaterialJoint> findAll();

	MaterialJoint findOne(Long id);

	void delete(Long id);

	MaterialJoint findByName(String name);

	Page<MaterialJoint> findAll(SimpleFilter filter, Pageable pageable);
}
