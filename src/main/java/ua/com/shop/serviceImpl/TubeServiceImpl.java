package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.filter.TubeFilter;
import ua.com.shop.dto.form.TubeForm;
import ua.com.shop.entity.Tube;
import ua.com.shop.repository.TubeRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.TubeService;
import ua.com.shop.specification.TubeSpecification;

@Service
public class TubeServiceImpl implements TubeService {

	@Autowired
	private TubeRepository tubeRepository;

	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(TubeForm form) {
		Tube entity = new Tube();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = tubeRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.TUBE, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			tubeRepository.save(entity);
		}
	}

	@Override
	public List<Tube> findAll() {
		return tubeRepository.findAll();
	}

	@Override
	public Tube findOne(Long id) {
		return tubeRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		tubeRepository.delete(id);
	}

	@Override
	public Page<Tube> findAll(SimpleFilter filter, Pageable pageable) {
		return tubeRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Tube> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public Tube findByName(String name) {
		return tubeRepository.findByName(name);
	}

	@Override
	public TubeForm findForm(Long id) {
		Tube entity = findOne(id);
		TubeForm form = new TubeForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<Tube> findByUserId(Long id) {
		return tubeRepository.findByUserId(id);
	}

	@Override
	public Page<Tube> findAll(Pageable pageable, TubeFilter filter) {
		return tubeRepository.findAll(new TubeSpecification(filter), pageable);
	}

	@Override
	public List<Tube> findByOrderId(Long orderId) {
		return tubeRepository.findByOrderId(orderId);
	}

}
