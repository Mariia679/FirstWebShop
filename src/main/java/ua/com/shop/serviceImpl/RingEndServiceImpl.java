package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.RingEnd;
import ua.com.shop.repository.RingEndRepository;
import ua.com.shop.service.RingEndService;

@Service
public class RingEndServiceImpl implements RingEndService {

	@Autowired
	private RingEndRepository ringEndRepository;

	public List<RingEnd> findAll() {
		return ringEndRepository.findAll();
	}

	public RingEnd findOne(Long id) {
		return ringEndRepository.findOne(id);
	}

	public void delete(Long id) {
		ringEndRepository.delete(id);
	}

	public void save(RingEnd t) {
		ringEndRepository.save(t);
	}

	public RingEnd findByName(String name) {
		return ringEndRepository.findByName(name);
	}

	@Override
	public Page<RingEnd> findAll(SimpleFilter filter, Pageable pageable) {
		return ringEndRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<RingEnd> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
