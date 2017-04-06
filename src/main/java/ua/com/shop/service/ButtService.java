package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Butt;

public interface ButtService {

	// void save(Butt t);
	
	Butt save(Butt t);

	List<Butt> findAll();

	Butt findOne(Long id);

	void delete(Long id);

	Butt findByName(String name);

	Page<Butt> findAll(SimpleFilter filter, Pageable pageable);
}
