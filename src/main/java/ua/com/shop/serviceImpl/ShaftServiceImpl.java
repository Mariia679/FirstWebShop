package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Shaft;
import ua.com.shop.repository.ShaftRepository;
import ua.com.shop.service.ShaftService;

@Service
public class ShaftServiceImpl implements ShaftService {

	@Autowired
	private ShaftRepository shaftRepository;

	public List<Shaft> findAll() {
		return shaftRepository.findAll();
	}

	public Shaft findOne(Long id) {
		return shaftRepository.findOne(id);
	}

	public void delete(Long id) {
		shaftRepository.delete(id);
	}

	public void save(Shaft t) {
		shaftRepository.save(t);
	}

	public Shaft findByName(String name) {
		return shaftRepository.findByName(name);
	}

	@Override
	public Page<Shaft> findAll(SimpleFilter filter, Pageable pageable) {
		return shaftRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Shaft> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
