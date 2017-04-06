package ua.com.shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.ProductDescription;

public interface ProductDescriptionService {

	void save(ProductDescription t);

	List<ProductDescription> findAll();

	ProductDescription findOne(Long id);

	void delete(Long id);
}
