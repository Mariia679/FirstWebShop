package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.repository.MaterialJointRepository;
import ua.com.shop.service.MaterialJointService;

@Service
public class MaterialJointServiceImpl implements MaterialJointService {
	@Autowired
	private MaterialJointRepository materialJointRepository;

	public List<MaterialJoint> findAll() {
		return materialJointRepository.findAll();
	}

	public MaterialJoint findOne(Long id) {
		return materialJointRepository.findOne(id);
	}

	public void delete(Long id) {
		materialJointRepository.delete(id);
	}

	public void save(MaterialJoint t) {
		materialJointRepository.save(t);
	}

	public MaterialJoint findByName(String name) {
		return materialJointRepository.findByName(name);
	}

	@Override
	public Page<MaterialJoint> findAll(SimpleFilter filter, Pageable pageable) {
		return materialJointRepository
				.findAll(findByNameLike(filter), pageable);
	}

	private Specification<MaterialJoint> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
