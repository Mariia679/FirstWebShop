package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.UkrMailFilter;
import ua.com.shop.entity.City;
import ua.com.shop.entity.UkrMail;

public interface UkrMailService {

	void save(UkrMail ukrMail);

	List<UkrMail> findAll();

	UkrMail findOne(Long id);

	void delete(Long id);

	UkrMail findUnique(String department, City city);

	void setNullUkrMail(Long id);

	Page<UkrMail> findAll(UkrMailFilter filter, Pageable pageable);
}
