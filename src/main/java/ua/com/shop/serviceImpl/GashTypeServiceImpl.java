package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.GashType;
import ua.com.shop.repository.GashTypeRepository;
import ua.com.shop.service.GashTypeService;

@Service
public class GashTypeServiceImpl implements GashTypeService {
	@Autowired
	private GashTypeRepository gashTypeRepository;

	public List<GashType> findAll() {
		return gashTypeRepository.findAll();
	}

	public GashType findOne(Long id) {
		return gashTypeRepository.findOne(id);
	}

	public void delete(Long id) {
		gashTypeRepository.delete(id);
	}

	public void save(GashType t) {
		gashTypeRepository.save(t);
	}

	public GashType findByName(String name) {
		return gashTypeRepository.findByName(name);
	}

	@Override
	public Page<GashType> findAll(SimpleFilter filter, Pageable pageable) {
		return gashTypeRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<GashType> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
