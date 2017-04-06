package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.filter.ProductCareFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.ProductCareForm;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.repository.ProductCareRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.specification.ProductCareSpecification;

@Service
public class ProductCareServiceImpl implements ProductCareService {

	@Autowired
	private ProductCareRepository productCareRepository;

	@Autowired
	private FileWriter fileWriter;

	@Override
	public void save(ProductCareForm form) {
		ProductCare entity = new ProductCare();
		entity.setDescription(form.getDescription());
		entity.setId(form.getId());
		entity.setFile(form.getFile());
		entity.setName(form.getName());
		entity.setPrice(new Integer(form.getPrice()));
		entity.setVersion(form.getVersion());
		MultipartFile file = entity.getFile();
		entity = productCareRepository.saveAndFlush(entity);
		if (fileWriter.write(Folder.PRODUCT_CARE, file, entity.getId())) {
			entity.setVersion(entity.getVersion() + 1);
			productCareRepository.save(entity);
		}
	}

	@Override
	public List<ProductCare> findAll() {
		return productCareRepository.findAll();
	}

	@Override
	public ProductCare findOne(Long id) {
		return productCareRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		productCareRepository.delete(id);
	}

	@Override
	public Page<ProductCare> findAll(SimpleFilter filter, Pageable pageable) {
		return productCareRepository.findAll(findByNameLike(filter), pageable);
	}

	private Specification<ProductCare> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch()
					.toLowerCase() + "%");
		};
	}

	@Override
	public ProductCare findByName(String name) {
		return productCareRepository.findByName(name);
	}

	@Override
	public ProductCareForm findForm(Long id) {
		ProductCare entity = findOne(id);
		ProductCareForm form = new ProductCareForm();
		form.setDescription(entity.getDescription());
		form.setId(entity.getId());
		form.setFile(entity.getFile());
		form.setName(entity.getName());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public List<ProductCare> findByUserId(Long id) {
		return productCareRepository.findByUserId(id);
	}

	@Override
	public Page<ProductCare> findAll(Pageable pageable, ProductCareFilter filter) {
		return productCareRepository.findAll(new ProductCareSpecification(
				filter), pageable);
	}

	@Override
	public List<ProductCare> findByOrderId(Long orderId) {
		return productCareRepository.findByOrderId(orderId);
		}
}
