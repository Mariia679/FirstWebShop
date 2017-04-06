package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.filter.StickerFilter;
import ua.com.shop.dto.form.StickerForm;
import ua.com.shop.entity.Sticker;
import ua.com.shop.repository.StickerRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.StickerService;
import ua.com.shop.specification.StickerSpecification;

@Service
public class StickerServiceImpl implements StickerService {

	@Autowired
	private StickerRepository stickerRepository;

	@Autowired
	private FileWriter fileWriter;

	public List<Sticker> findAll() {
		return stickerRepository.findAll();
	}

	public Sticker findOne(Long id) {
		return stickerRepository.findOne(id);
	}

	public void delete(Long id) {
		stickerRepository.delete(id);
	}

	public void save(StickerForm form) {
		Sticker entity = new Sticker();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = stickerRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.STICKER, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			stickerRepository.save(entity);
		}
	}

	public Sticker findByName(String name) {
		return stickerRepository.findByName(name);
	}

	@Override
	public Page<Sticker> findAll(SimpleFilter filter, Pageable pageable) {
		return stickerRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Sticker> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public StickerForm findForm(Long id) {
		Sticker entity = findOne(id);
		StickerForm form = new StickerForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<Sticker> findByUserId(Long id) {
		return stickerRepository.findByUserId(id);
	}

	@Override
	public Page<Sticker> findAll(Pageable pageable, StickerFilter filter) {
		return stickerRepository.findAll(new StickerSpecification(filter),
				pageable);
	}

	@Override
	public List<Sticker> findByOrderId(Long orderId) {
		return stickerRepository.findByOrderId(orderId);
	}
}
