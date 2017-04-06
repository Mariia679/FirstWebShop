package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.GloveFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.GloveForm;
import ua.com.shop.entity.Glove;

public interface GloveService {

	void save(GloveForm t);

	List<Glove> findAll();

	Glove findOne(Long id);

	void delete(Long id);

	Page<Glove> findAll(SimpleFilter filter, Pageable pageable);

	Glove findByName(String name);

	GloveForm findForm(Long id);

	List<Glove> findByUserId(Long id);

	Page<Glove> findAll(Pageable pageable, GloveFilter filter);

	List<Glove> findByOrderId(Long orderId);

}
