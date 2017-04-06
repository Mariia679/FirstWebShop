package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.MotherInLawFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.MotherInLawForm;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.repository.MotherInLawRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.specification.MotherInLawSpecification;

@Service
public class MotherInLawServiceImpl implements MotherInLawService {

	@Autowired
	private MotherInLawRepository motherInLawRepository;

	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(MotherInLawForm form) {
		MotherInLaw entity = new MotherInLaw();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = motherInLawRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.MOTHER_IN_LAW, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			motherInLawRepository.save(entity);
		}
	}

	@Override
	public List<MotherInLaw> findAll() {
		return motherInLawRepository.findAll();
	}

	@Override
	public MotherInLaw findOne(Long id) {
		return motherInLawRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		motherInLawRepository.delete(id);
	}

	@Override
	public Page<MotherInLaw> findAll(SimpleFilter filter, Pageable pageable) {
		return motherInLawRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<MotherInLaw> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public MotherInLaw findByName(String name) {
		return motherInLawRepository.findByName(name);
	}

	@Override
	public MotherInLawForm findForm(Long id) {
		MotherInLaw entity = findOne(id);
		MotherInLawForm form = new MotherInLawForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<MotherInLaw> findByUserId(Long id) {
		return motherInLawRepository.findByUserId(id);
	}

	@Override
	public Page<MotherInLaw> findAll(Pageable pageable, MotherInLawFilter filter) {
		return motherInLawRepository.findAll(new MotherInLawSpecification(
				filter), pageable);
	}

	@Override
	public List<MotherInLaw> findByOrderId(Long orderId) {
		return motherInLawRepository.findByOrderId(orderId);
	}
}
