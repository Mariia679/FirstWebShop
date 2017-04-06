package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.RingBumper;
import ua.com.shop.repository.RingBumperRepository;
import ua.com.shop.service.RingBumperService;

@Service
public class RingBumperServiceImpl implements RingBumperService {

	@Autowired
	private RingBumperRepository ringBumperRepository;

	public List<RingBumper> findAll() {
		return ringBumperRepository.findAll();
	}

	public RingBumper findOne(Long id) {
		return ringBumperRepository.findOne(id);
	}

	public void delete(Long id) {
		ringBumperRepository.delete(id);
	}

	public void save(RingBumper t) {
		ringBumperRepository.save(t);
	}

	public RingBumper findByName(String name) {
		return ringBumperRepository.findByName(name);
	}

	@Override
	public Page<RingBumper> findAll(SimpleFilter filter, Pageable pageable) {
		return ringBumperRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<RingBumper> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
