package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Ferula;
import ua.com.shop.repository.FerulaRepository;
import ua.com.shop.service.FerulaService;

@Service
public class FerulaServiceImpl implements FerulaService {
	@Autowired
	private FerulaRepository ferulaRepository;

	public List<Ferula> findAll() {
		return ferulaRepository.findAll();
	}

	public Ferula findOne(Long id) {
		return ferulaRepository.findOne(id);
	}

	public void delete(Long id) {
		ferulaRepository.delete(id);
	}

	public void save(Ferula t) {
		ferulaRepository.save(t);
	}

	public Ferula findByName(String name) {
		return ferulaRepository.findByName(name);
	}

	@Override
	public Page<Ferula> findAll(SimpleFilter filter, Pageable pageable) {
		return ferulaRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Ferula> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

}
