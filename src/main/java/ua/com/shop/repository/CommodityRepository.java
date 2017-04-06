package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Long>,
		JpaSpecificationExecutor<Commodity> {

	@Query("SELECT a FROM Commodity a LEFT JOIN FETCH a.category "
			+ "LEFT JOIN FETCH a.mainMaterial " + "LEFT JOIN FETCH a.wood "
			+ "LEFT JOIN FETCH a.ferula " + "LEFT JOIN FETCH a.gashType "
			+ "LEFT JOIN FETCH a.sticker " + "LEFT JOIN FETCH a.typeSticker "
			+ "LEFT JOIN FETCH a.ringEnd " + "LEFT JOIN FETCH a.ringBumper "
			+ "LEFT JOIN FETCH a.damper " + "LEFT JOIN FETCH a.shaft "
			+ "LEFT JOIN FETCH a.butt " + "LEFT JOIN FETCH a.carvingJoint "
			+ "LEFT JOIN FETCH a.materialJoint " + "WHERE a.id=?1")
	Commodity findOne(Long id);

	@Query("SELECT a FROM Commodity a LEFT JOIN FETCH a.category "
			+ "LEFT JOIN FETCH a.mainMaterial " + "LEFT JOIN FETCH a.wood "
			+ "LEFT JOIN FETCH a.ferula " + "LEFT JOIN FETCH a.gashType "
			+ "LEFT JOIN FETCH a.sticker " + "LEFT JOIN FETCH a.typeSticker "
			+ "LEFT JOIN FETCH a.ringEnd " + "LEFT JOIN FETCH a.ringBumper "
			+ "LEFT JOIN FETCH a.damper " + "LEFT JOIN FETCH a.shaft "
			+ "LEFT JOIN FETCH a.butt " + "LEFT JOIN FETCH a.carvingJoint "
			+ "LEFT JOIN FETCH a.materialJoint")
	List<Commodity> findAll();

	// method for make a validation if the record exists

	@Query("SELECT c FROM Commodity c WHERE c.butt.id = ?1 AND c.carvingJoint.id = ?2 "
			+ "AND c.category.id = ?3 AND c.damper.id = ?4 AND c.ferula.id = ?5 "
			+ "AND c.gashType.id = ?6 AND c.length = ?7 AND c.mainMaterial.id = ?8 "
			+ "AND c.name = ?9 AND c.price = ?10 AND c.ringBumper.id = ?11 "
			+ "AND c.ringEnd.id = ?12 AND c.shaft.id = ?13 AND c.sticker.id = ?14 "
			+ "AND c.typeSticker.id = ?15 AND c.weight = ?16 AND c.wood.id = ?17 ")
	Commodity findUnique(Long buttId, Long carvingJointId, Long categoryId,
			Long damperId, Long ferulaId, Long gashTypeId, String length,
			Long mainMaterialId, String name, Integer price, Long ringBumperId,
			Long ringEndId, Long shaftId, Long stickerId, Long typeStickerId,
			String weight, Long woodId);

	// find of the quantity of goods at the shopping cart

	@Query("SELECT ci.count FROM User u JOIN u.cartItem ci WHERE u.id=?1")
	Long findCount(Long id);

	// find commodity at the cart by user id

	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.category "
			+ "LEFT JOIN FETCH c.mainMaterial " + "LEFT JOIN FETCH c.wood "
			+ "LEFT JOIN FETCH c.ferula " + "LEFT JOIN FETCH c.gashType "
			+ "LEFT JOIN FETCH c.sticker " + "LEFT JOIN FETCH c.typeSticker "
			+ "LEFT JOIN FETCH c.ringEnd " + "LEFT JOIN FETCH c.ringBumper "
			+ "LEFT JOIN FETCH c.damper " + "LEFT JOIN FETCH c.shaft "
			+ "LEFT JOIN FETCH c.butt " + "LEFT JOIN FETCH c.carvingJoint "
			+ "LEFT JOIN FETCH c.materialJoint "
			+ "JOIN c.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<Commodity> findByUserId(Long userId);

	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.category "
			+ "LEFT JOIN FETCH c.mainMaterial " + "LEFT JOIN FETCH c.wood "
			+ "LEFT JOIN FETCH c.ferula " + "LEFT JOIN FETCH c.gashType "
			+ "LEFT JOIN FETCH c.sticker " + "LEFT JOIN FETCH c.typeSticker "
			+ "LEFT JOIN FETCH c.ringEnd " + "LEFT JOIN FETCH c.ringBumper "
			+ "LEFT JOIN FETCH c.damper " + "LEFT JOIN FETCH c.shaft "
			+ "LEFT JOIN FETCH c.butt " + "LEFT JOIN FETCH c.carvingJoint "
			+ "LEFT JOIN FETCH c.materialJoint "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<Commodity> findByOrderId(Long userId);

	// Set null to record of entity commodity via query update

	@Modifying
	@Transactional
	@Query("update Commodity c set c.butt = null where c.butt.id = ?1")
	void setNullButt(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.carvingJoint = null where c.carvingJoint.id = ?1")
	void setNullCarvingJoint(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.category = null where c.category.id = ?1")
	void setNullCategory(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.damper = null where c.damper.id = ?1")
	void setNullDamper(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.ferula = null where c.ferula.id = ?1")
	void setNullFerula(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.gashType = null where c.gashType.id = ?1")
	void setNullGashType(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.materialJoint = null where c.materialJoint.id = ?1")
	void setNullMaterialJoint(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.ringBumper = null where c.ringBumper.id = ?1")
	void setNullRingBumper(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.ringEnd = null where c.ringEnd.id = ?1")
	void setNullRingEnd(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.shaft = null where c.shaft.id = ?1")
	void setNullShaft(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.sticker = null where c.sticker.id = ?1")
	void setNullSticker(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.typeSticker = null where c.typeSticker.id = ?1")
	void setNullTypeSticker(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.wood = null where c.wood.id = ?1")
	void setNullWood(Long id);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.mainMaterial = null where c.mainMaterial.id = ?1")
	void setNullMainMaterial(Long id);

	@Query(value = "SELECT a FROM Commodity a LEFT JOIN FETCH a.category "
			+ "LEFT JOIN FETCH a.mainMaterial " + "LEFT JOIN FETCH a.wood "
			+ "LEFT JOIN FETCH a.ferula " + "LEFT JOIN FETCH a.gashType "
			+ "LEFT JOIN FETCH a.sticker " + "LEFT JOIN FETCH a.typeSticker "
			+ "LEFT JOIN FETCH a.ringEnd " + "LEFT JOIN FETCH a.ringBumper "
			+ "LEFT JOIN FETCH a.damper " + "LEFT JOIN FETCH a.shaft "
			+ "LEFT JOIN FETCH a.butt " + "LEFT JOIN FETCH a.carvingJoint "
			+ "LEFT JOIN FETCH a.materialJoint " + "ORDER BY a.count DESC", countQuery = "SELECT count(a.id) FROM Commodity a")
	Page<Commodity> findAll(Pageable pageable);

	@Modifying
	@Transactional
	@Query("update Commodity c set c.count = ?1 where c.id = ?2")
	void addCount(int count, Long commodityId);

}
