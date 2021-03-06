package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.RingBumper;

public interface RingBumperService {
	void save(RingBumper t);

	List<RingBumper> findAll();

	RingBumper findOne(Long id);

	void delete(Long id);

	RingBumper findByName(String name);

	Page<RingBumper> findAll(SimpleFilter filter, Pageable pageable);
}
