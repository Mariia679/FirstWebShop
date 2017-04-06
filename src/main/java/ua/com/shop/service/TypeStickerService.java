package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.TypeSticker;

public interface TypeStickerService {
	void save(TypeSticker t);

	List<TypeSticker> findAll();

	TypeSticker findOne(Long id);

	void delete(Long id);

	TypeSticker findByName(String name);

	Page<TypeSticker> findAll(SimpleFilter filter, Pageable pageable);
}
