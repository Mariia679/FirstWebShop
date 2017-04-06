package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MainPage;

public interface MainPageService {

	void save(MainPage t);

	List<MainPage> findAll();

	MainPage findOne(Long id);

	void delete(Long id);

	MainPage findUnique(String name, String string);

	Page<MainPage> findAll(SimpleFilter filter, Pageable pageable);

}
