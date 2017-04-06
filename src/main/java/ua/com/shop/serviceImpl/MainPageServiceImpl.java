package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.MainPage;
import ua.com.shop.repository.MainPageRepository;
import ua.com.shop.service.MainPageService;

@Service
public class MainPageServiceImpl implements MainPageService {

	@Autowired
	private MainPageRepository mainPageRepository;

	@Override
	public void save(MainPage entity) {
		// MainPage entity = new MainPage();
		// String content = form.getContent();
		// byte[] byte_string = content.getBytes();
		//
		// Blob blob = null;
		// try {
		// blob = new SerialBlob(byte_string);
		// } catch (SerialException e) {
		// e.printStackTrace();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// entity.setContent(blob);
		mainPageRepository.save(entity);
	}

	@Override
	public List<MainPage> findAll() {
		return mainPageRepository.findAll();
	}

	@Override
	public MainPage findOne(Long id) {
		return mainPageRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		mainPageRepository.delete(id);
	}

	@Override
	public MainPage findUnique(String name, String content) {
		return mainPageRepository.findUnique(name, content);
	}

	@Override
	public Page<MainPage> findAll(SimpleFilter filter, Pageable pageable) {
		return mainPageRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<MainPage> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}
}
