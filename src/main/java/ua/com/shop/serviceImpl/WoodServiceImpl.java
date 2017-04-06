package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Wood;
import ua.com.shop.repository.WoodRepository;
import ua.com.shop.service.WoodService;

@Service
public class WoodServiceImpl implements WoodService {

	@Autowired
	private WoodRepository woodRepository;

	public List<Wood> findAll() {
		return woodRepository.findAll();
	}

	public Wood findOne(Long id) {
		return woodRepository.findOne(id);
	}

	public void delete(Long id) {
		woodRepository.delete(id);
	}

	public void save(Wood t) {
		woodRepository.save(t);
	}

	public Wood findByName(String name) {
		return woodRepository.findByName(name);
	}

	@Override
	public Page<Wood> findAll(SimpleFilter filter, Pageable pageable) {
		return woodRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Wood> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
