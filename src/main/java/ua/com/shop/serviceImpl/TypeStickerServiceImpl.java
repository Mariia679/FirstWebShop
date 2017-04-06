package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.TypeSticker;
import ua.com.shop.repository.TypeStickerRepository;
import ua.com.shop.service.TypeStickerService;

@Service
public class TypeStickerServiceImpl implements TypeStickerService {

	@Autowired
	private TypeStickerRepository typeStickerRepository;

	public List<TypeSticker> findAll() {
		return typeStickerRepository.findAll();
	}

	public TypeSticker findOne(Long id) {
		return typeStickerRepository.findOne(id);
	}

	public void delete(Long id) {
		typeStickerRepository.delete(id);
	}

	public void save(TypeSticker t) {
		typeStickerRepository.save(t);
	}

	public TypeSticker findByName(String name) {
		return typeStickerRepository.findByName(name);
	}

	@Override
	public Page<TypeSticker> findAll(SimpleFilter filter, Pageable pageable) {
		return typeStickerRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<TypeSticker> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
