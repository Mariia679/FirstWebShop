package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.NewMailFilter;
import ua.com.shop.entity.City;
import ua.com.shop.entity.NewMail;

public interface NewMailService {

	void save(NewMail newMail);

	List<NewMail> findAll();

	NewMail findOne(Long id);

	void delete(Long id);

	NewMail findUnique(String department, City city);

	void setNullNewMail(Long id);

	Page<NewMail> findAll(Pageable pageable, NewMailFilter filter);

}
