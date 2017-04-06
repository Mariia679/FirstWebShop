package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.HoldersChalkFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.HoldersChalkForm;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.repository.HoldersChalkRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.specification.HoldersChalkSpecification;

@Service
public class HoldersChalkServiceImpl implements HoldersChalkService {

	@Autowired
	private HoldersChalkRepository holdersChalkRepository;
	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(HoldersChalkForm form) {
		HoldersChalk entity = new HoldersChalk();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = holdersChalkRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.HOLDERS_CHALK, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			holdersChalkRepository.save(entity);
		}
	}

	@Override
	public List<HoldersChalk> findAll() {
		return holdersChalkRepository.findAll();
	}

	@Override
	public HoldersChalk findOne(Long id) {
		return holdersChalkRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		holdersChalkRepository.delete(id);
	}

	@Override
	public Page<HoldersChalk> findAll(SimpleFilter filter, Pageable pageable) {
		return holdersChalkRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<HoldersChalk> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public HoldersChalk findByName(String name) {
		return holdersChalkRepository.findByName(name);
	}

	@Override
	public HoldersChalkForm findForm(Long id) {
		HoldersChalk entity = findOne(id);
		HoldersChalkForm form = new HoldersChalkForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<HoldersChalk> findByUserId(Long id) {
		return holdersChalkRepository.findByUserId(id);
	}

	@Override
	public Page<HoldersChalk> findAll(Pageable pageable,
			HoldersChalkFilter filter) {
		return holdersChalkRepository.findAll(new HoldersChalkSpecification(
				filter), pageable);
	}

	@Override
	public List<HoldersChalk> findByOrderId(Long orderId) {
		return holdersChalkRepository.findByOrderId(orderId);
	}

}
