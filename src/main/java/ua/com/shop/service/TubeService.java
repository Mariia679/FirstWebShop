package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.filter.TubeFilter;
import ua.com.shop.dto.form.TubeForm;
import ua.com.shop.entity.Tube;

public interface TubeService {

	void save(TubeForm t);

	List<Tube> findAll();

	Tube findOne(Long id);

	void delete(Long id);

	Page<Tube> findAll(SimpleFilter filter, Pageable pageable);

	Tube findByName(String name);

	TubeForm findForm(Long id);

	List<Tube> findByUserId(Long id);

	Page<Tube> findAll(Pageable pageable, TubeFilter filter);

	List<Tube> findByOrderId(Long orderId);
}
