package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.filter.StickerFilter;
import ua.com.shop.dto.form.StickerForm;
import ua.com.shop.entity.Sticker;

public interface StickerService {

	void save(StickerForm t);

	List<Sticker> findAll();

	Sticker findOne(Long id);

	void delete(Long id);

	Sticker findByName(String name);

	Page<Sticker> findAll(SimpleFilter filter, Pageable pageable);

	StickerForm findForm(Long id);

	List<Sticker> findByUserId(Long id);

	Page<Sticker> findAll(Pageable pageable, StickerFilter filter);

	List<Sticker> findByOrderId(Long orderId);
}
