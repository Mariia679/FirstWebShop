package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Butt;
import ua.com.shop.repository.ButtRepository;
import ua.com.shop.service.ButtService;
import ua.com.shop.specification.ButtSpecification;

@Service
public class ButtServiceImpl implements ButtService {

	@Autowired
	private ButtRepository buttRepository;

	@Override
	public Butt save(Butt t) {
		return buttRepository.saveAndFlush(t);
	}

	@Override
	public List<Butt> findAll() {
		return buttRepository.findAll();
	}

	@Override
	public Butt findOne(Long id) {
		return buttRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		buttRepository.delete(id);
	}

	@Override
	public Butt findByName(String name) {
		return buttRepository.findByName(name);
	}

	@Override
	public Page<Butt> findAll(SimpleFilter filter, Pageable pageable) {
		return buttRepository.findAll(new ButtSpecification(filter), pageable);
	}

	// @Override
	// public Page<Butt> findAll(SimpleFilter filter, Pageable pageable) {
	// return buttRepository.findAll(findByNameLike(filter), pageable);
	// }
	//
	// private Specification<Butt> findByNameLike(SimpleFilter filter) {
	// return (root, query, cb) -> {
	// if (filter.getSearch().isEmpty())
	// return null;
	// return cb.like(cb.lower(root.get("name")), filter.getSearch()
	// .toLowerCase() + "%");
	// };
	// }

}
