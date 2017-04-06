package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.ProductDescription;
import ua.com.shop.repository.ProductDescriptionRepository;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.ProductDescriptionService;
import ua.com.shop.service.FileWriter.Folder;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

	@Autowired
	private ProductDescriptionRepository productDescriptionRepository;

	@Autowired
	private FileWriter fileWriter;

	public List<ProductDescription> findAll() {
		return productDescriptionRepository.findAll();
	}

	public ProductDescription findOne(Long id) {
		return productDescriptionRepository.findOne(id);
	}

	public void delete(Long id) {
		productDescriptionRepository.delete(id);
	}

	public void save(ProductDescription productDescription) {
		MultipartFile file = productDescription.getFile();
		productDescription = productDescriptionRepository
				.saveAndFlush(productDescription);
		if (fileWriter.write(Folder.DESC, file, productDescription.getId())) {

			productDescription.setVersion(productDescription.getVersion() + 1);
			productDescriptionRepository.save(productDescription);
		}

	}

}
