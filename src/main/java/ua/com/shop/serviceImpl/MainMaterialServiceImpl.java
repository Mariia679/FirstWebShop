package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MainMaterial;
import ua.com.shop.repository.MainMaterialRepository;
import ua.com.shop.service.MainMaterialService;

@Service
public class MainMaterialServiceImpl implements MainMaterialService {

	@Autowired
	private MainMaterialRepository mainMaterialRepository;

	public List<MainMaterial> findAll() {
		return mainMaterialRepository.findAll();
	}

	public MainMaterial findOne(Long id) {
		return mainMaterialRepository.findOne(id);
	}

	public void delete(Long id) {
		mainMaterialRepository.delete(id);
	}

	public void save(MainMaterial t) {
		mainMaterialRepository.save(t);
	}

	public MainMaterial findByName(String name) {
		return mainMaterialRepository.findByName(name);
	}

	@Override
	public Page<MainMaterial> findAll(SimpleFilter filter, Pageable pageable) {
		return mainMaterialRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<MainMaterial> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

}
