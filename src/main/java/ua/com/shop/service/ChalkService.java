package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.ChalkFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.ChalkForm;
import ua.com.shop.entity.Chalk;

public interface ChalkService {

	void save(ChalkForm t);

	List<Chalk> findAll();

	Chalk findOne(Long id);

	void delete(Long id);

	Page<Chalk> findAll(SimpleFilter filter, Pageable pageable);

	Chalk findByName(String name);

	ChalkForm findForm(Long id);

	List<Chalk> findByUserId(Long id);

	Page<Chalk> findAll(Pageable pageable, ChalkFilter filter);

	List<Chalk> findByOrderId(Long orderId);

	

}
