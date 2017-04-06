package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.repository.CategoryRepository;
import ua.com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void save(Category t) {
		categoryRepository.save(t);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public Page<Category> findAll(SimpleFilter filter, Pageable pageable) {
		return categoryRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Category> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

}
