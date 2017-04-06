package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.GloveFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.GloveForm;
import ua.com.shop.entity.Glove;
import ua.com.shop.repository.GloveRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.GloveService;
import ua.com.shop.specification.GloveSpecification;

@Service
public class GloveServiceImpl implements GloveService {

	@Autowired
	private GloveRepository gloveRepository;

	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(GloveForm form) {
		Glove entity = new Glove();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = gloveRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.GLOVE, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			gloveRepository.save(entity);
		}
	}

	@Override
	public List<Glove> findAll() {
		return gloveRepository.findAll();
	}

	@Override
	public Glove findOne(Long id) {
		return gloveRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		gloveRepository.delete(id);
	}

	@Override
	public Page<Glove> findAll(SimpleFilter filter, Pageable pageable) {
		return gloveRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Glove> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public Glove findByName(String name) {
		return gloveRepository.findByName(name);
	}

	@Override
	public GloveForm findForm(Long id) {
		Glove entity = findOne(id);
		GloveForm form = new GloveForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<Glove> findByUserId(Long id) {
		return gloveRepository.findByUserId(id);
	}

	@Override
	public Page<Glove> findAll(Pageable pageable, GloveFilter filter) {
		return gloveRepository
				.findAll(new GloveSpecification(filter), pageable);
	}

	@Override
	public List<Glove> findByOrderId(Long orderId) {
		return gloveRepository.findByOrderId(orderId);
	}

}
