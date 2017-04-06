package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Reviews;

public interface ReviewsService {

	void save(Reviews t);

	List<Reviews> findAll();

	Reviews findOne(Long id);

	void delete(Long id);

	List<Reviews> findByCommodity(Long commodityId);

	List<Reviews> findByTube(Long tubeId);

	List<Reviews> findByStickers(Long stickerId);

	List<Reviews> findByChalk(Long chalkId);

	List<Reviews> findByProductCare(Long productCareId);

	List<Reviews> findByMotherInLaw(Long motherInLawId);

	List<Reviews> findByHoldersChalk(Long stickerId);

	List<Reviews> findByGloves(Long gloveId);


}
