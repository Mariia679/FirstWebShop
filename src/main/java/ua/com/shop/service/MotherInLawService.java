package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.MotherInLawFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.MotherInLawForm;
import ua.com.shop.entity.MotherInLaw;

public interface MotherInLawService {

	void save(MotherInLawForm entity);

	List<MotherInLaw> findAll();

	MotherInLaw findOne(Long id);

	void delete(Long id);

	Page<MotherInLaw> findAll(SimpleFilter filter, Pageable pageable);

	MotherInLaw findByName(String name);

	MotherInLawForm findForm(Long id);
	
	List<MotherInLaw> findByUserId(Long id);
	
	Page<MotherInLaw> findAll(Pageable pageable, MotherInLawFilter filter);

	List<MotherInLaw> findByOrderId(Long orderId);
}
