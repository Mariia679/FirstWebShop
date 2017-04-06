package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MethodDelivery;

public interface MethodDeliveryService {

	void save(MethodDelivery t);

	List<MethodDelivery> findAll();

	MethodDelivery findOne(Long id);

	void delete(Long id);

	MethodDelivery findByTitle(String title);

	Page<MethodDelivery> findAll(SimpleFilter filter, Pageable pageable);
}
