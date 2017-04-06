package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long>,
		JpaSpecificationExecutor<Reviews> {

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.user WHERE r.id=?1")
	Reviews findOne(Long id);

	// @Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
	// + "LEFT JOIN FETCH r.user")
	// List<Reviews> findAll();

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube " 
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove " 
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare "
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.commodity.id=?1")
	List<Reviews> findByCommodity(Long commodityId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube "
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove " 
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare " 
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.tube.id=?1")
	List<Reviews> findByTube(Long tubeId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube " 
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove "
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare "
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.glove.id=?1")
	List<Reviews> findByGloves(Long gloveId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube " 
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove "
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare " 
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.holdersChalk.id=?1")
	List<Reviews> findByHoldersChalk(Long chalkId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube " 
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove " 
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare "
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.motherInLaw.id=?1")
	List<Reviews> findByMotherInLaw(Long motherInLawId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube "
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove " 
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare "
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.productCare.id=?1")
	List<Reviews> findByProductCare(Long productCareId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube " 
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove "
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare "
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.chalk.id=?1")
	List<Reviews> findByChalk(Long chalkId);

	@Query("SELECT r FROM Reviews r LEFT JOIN FETCH r.commodity "
			+ "LEFT JOIN FETCH r.tube "
			+ "LEFT JOIN FETCH r.chalk "
			+ "LEFT JOIN FETCH r.glove " 
			+ "LEFT JOIN FETCH r.holdersChalk "
			+ "LEFT JOIN FETCH r.productCare "
			+ "LEFT JOIN FETCH r.sticker "
			+ "LEFT JOIN FETCH r.user  WHERE r.sticker.id=?1")
	List<Reviews> findByStickers(Long stickerId);

}
