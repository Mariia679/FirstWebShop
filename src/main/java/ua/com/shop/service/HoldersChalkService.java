package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.HoldersChalkFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.HoldersChalkForm;
import ua.com.shop.entity.HoldersChalk;

public interface HoldersChalkService {

	void save(HoldersChalkForm entity);

	List<HoldersChalk> findAll();

	HoldersChalk findOne(Long id);

	void delete(Long id);

	Page<HoldersChalk> findAll(SimpleFilter filter, Pageable pageable);

	HoldersChalk findByName(String name);

	HoldersChalkForm findForm(Long id);

	List<HoldersChalk> findByUserId(Long id);

	Page<HoldersChalk> findAll(Pageable pageable, HoldersChalkFilter filter);

	List<HoldersChalk> findByOrderId(Long orderId);

}
