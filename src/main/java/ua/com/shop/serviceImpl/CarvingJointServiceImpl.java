package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.repository.CarvingJointRepository;
import ua.com.shop.service.CarvingJointService;

@Service
public class CarvingJointServiceImpl implements CarvingJointService {
	@Autowired
	private CarvingJointRepository carvingJointRepository;

	public void save(CarvingJoint t) {
		carvingJointRepository.save(t);
	}

	public List<CarvingJoint> findAll() {
		return carvingJointRepository.findAll();
	}

	public CarvingJoint findOne(Long id) {
		return carvingJointRepository.findOne(id);
	}

	public void delete(Long id) {
		carvingJointRepository.delete(id);
	}

	public CarvingJoint findByName(String name) {
		return carvingJointRepository.findByName(name);
	}

	@Override
	public Page<CarvingJoint> findAll(SimpleFilter filter, Pageable pageable) {
		return carvingJointRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<CarvingJoint> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

}
