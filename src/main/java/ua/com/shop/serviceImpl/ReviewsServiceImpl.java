package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.entity.Reviews;
import ua.com.shop.repository.ReviewsRepository;
import ua.com.shop.service.ReviewsService;

@Service
public class ReviewsServiceImpl implements ReviewsService {

	@Autowired
	private ReviewsRepository reviewsRepository;

	@Override
	public void save(Reviews t) {
		reviewsRepository.save(t);
	}

	@Override
	public List<Reviews> findAll() {
		return reviewsRepository.findAll();
	}

	@Override
	public Reviews findOne(Long id) {
		return reviewsRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		reviewsRepository.delete(id);
	}

	@Override
	public List<Reviews> findByCommodity(Long commodityId) {
		return reviewsRepository.findByCommodity(commodityId);
	}

	@Override
	public List<Reviews> findByTube(Long tubeId) {
		return reviewsRepository.findByTube(tubeId);
	}

	@Override
	public List<Reviews> findByStickers(Long stickerId) {
		return reviewsRepository.findByStickers(stickerId);
	}

	@Override
	public List<Reviews> findByChalk(Long chalkId) {
		return reviewsRepository.findByChalk(chalkId);
	}

	@Override
	public List<Reviews> findByProductCare(Long productCareId) {
		return reviewsRepository.findByProductCare(productCareId);
	}

	@Override
	public List<Reviews> findByMotherInLaw(Long motherInLawId) {
		return reviewsRepository.findByMotherInLaw(motherInLawId);
	}

	@Override
	public List<Reviews> findByHoldersChalk(Long chalkId) {
		return reviewsRepository.findByHoldersChalk(chalkId);
	}

	@Override
	public List<Reviews> findByGloves(Long gloveId) {
		return reviewsRepository.findByGloves(gloveId);
	}

}
