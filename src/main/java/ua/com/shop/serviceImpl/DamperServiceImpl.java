package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Damper;
import ua.com.shop.repository.DamperRepository;
import ua.com.shop.service.DamperService;

@Service
public class DamperServiceImpl implements DamperService {
	@Autowired
	private DamperRepository damperRepository;

	public List<Damper> findAll() {
		return damperRepository.findAll();
	}

	public Damper findOne(Long id) {
		return damperRepository.findOne(id);
	}

	public void delete(Long id) {
		damperRepository.delete(id);
	}

	public void save(Damper t) {
		damperRepository.save(t);
	}

	public Damper findByName(String name) {
		return damperRepository.findByName(name);
	}

	@Override
	public Page<Damper> findAll(SimpleFilter filter, Pageable pageable) {
		return damperRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Damper> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

}
