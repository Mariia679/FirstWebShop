package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Sticker;

public interface StickerRepository extends JpaRepository<Sticker, Long>,
		JpaSpecificationExecutor<Sticker> {

	Sticker findByName(String name);

	@Query("SELECT t FROM Sticker t JOIN t.cartItems ci JOIN ci.users u WHERE u.id=?1")
	List<Sticker> findByUserId(Long id);
	
	@Query("SELECT c FROM Sticker c "
			+ "JOIN c.order co  WHERE co.id=?1")
	List<Sticker> findByOrderId(Long userId);

}
