package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.ChalkFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.ChalkForm;
import ua.com.shop.entity.Chalk;
import ua.com.shop.repository.ChalkRepository;
import ua.com.shop.service.ChalkService;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.specification.ChalkSpecification;

@Service
public class ChalkServiceImpl implements ChalkService {

	@Autowired
	private ChalkRepository chalkRepository;

	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(ChalkForm form) {
		Chalk entity = new Chalk();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = chalkRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.CHALK, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			chalkRepository.save(entity);
		}
	}

	@Override
	public List<Chalk> findAll() {
		return chalkRepository.findAll();
	}

	@Override
	public Chalk findOne(Long id) {
		return chalkRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		chalkRepository.delete(id);
	}

	@Override
	public Chalk findByName(String name) {
		return chalkRepository.findByName(name);
	}

	@Override
	public Page<Chalk> findAll(SimpleFilter filter, Pageable pageable) {
		return chalkRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Chalk> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public ChalkForm findForm(Long id) {
		Chalk entity = findOne(id);
		ChalkForm form = new ChalkForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<Chalk> findByUserId(Long id) {
		return chalkRepository.findByUserId(id);
	}

	@Override
	public Page<Chalk> findAll(Pageable pageable, ChalkFilter filter) {
		return chalkRepository
				.findAll(new ChalkSpecification(filter), pageable);
	}

	@Override
	public List<Chalk> findByOrderId(Long orderId) {
		return chalkRepository.findByOrderId(orderId);
	}

}
