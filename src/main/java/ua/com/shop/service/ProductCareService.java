package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.ProductCareFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.ProductCareForm;
import ua.com.shop.entity.ProductCare;

public interface ProductCareService {

	void save(ProductCareForm entity);

	List<ProductCare> findAll();

	ProductCare findOne(Long id);

	void delete(Long id);

	Page<ProductCare> findAll(SimpleFilter filter, Pageable pageable);

	ProductCare findByName(String name);

	ProductCareForm findForm(Long id);

	List<ProductCare> findByUserId(Long id);

	Page<ProductCare> findAll(Pageable pageable, ProductCareFilter filter);

	List<ProductCare> findByOrderId(Long orderId);
}
