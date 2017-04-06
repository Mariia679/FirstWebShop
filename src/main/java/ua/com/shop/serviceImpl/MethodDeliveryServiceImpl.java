package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MethodDelivery;
import ua.com.shop.repository.MethodDeliveryRepository;
import ua.com.shop.service.MethodDeliveryService;

@Service
public class MethodDeliveryServiceImpl implements MethodDeliveryService {

	@Autowired
	private MethodDeliveryRepository methodDeliveryRepository;

	public List<MethodDelivery> findAll() {
		return methodDeliveryRepository.findAll();
	}

	public MethodDelivery findOne(Long id) {
		return methodDeliveryRepository.findOne(id);
	}

	public void delete(Long id) {
		methodDeliveryRepository.delete(id);
	}

	public void save(MethodDelivery t) {
		methodDeliveryRepository.save(t);
	}

	public MethodDelivery findByTitle(String title) {
		return methodDeliveryRepository.findByTitle(title);
	}

	@Override
	public Page<MethodDelivery> findAll(SimpleFilter filter, Pageable pageable) {
		return methodDeliveryRepository.findAll(findByTitleLike(filter),
				pageable);
	}

	private Specification<MethodDelivery> findByTitleLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("title")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
