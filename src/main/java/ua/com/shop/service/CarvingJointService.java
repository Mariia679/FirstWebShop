package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.CarvingJoint;

public interface CarvingJointService {

	void save(CarvingJoint t);

	List<CarvingJoint> findAll();

	CarvingJoint findOne(Long id);

	void delete(Long id);

	CarvingJoint findByName(String name);

	Page<CarvingJoint> findAll(SimpleFilter filter, Pageable pageable);
}
