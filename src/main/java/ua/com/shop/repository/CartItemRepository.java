package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.CartItem;
import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	@Query("SELECT cartItem.id FROM User u WHERE u.id=?1")
	Long findByUserId(Long userId);

	@Query(value = "SELECT c FROM Commodity c JOIN c.cartItems ci WHERE ci.id = ?1")
	Commodity findByCommodity(Long cartItemId);

	@Query("SELECT allPrice FROM CartItem ci WHERE ci.id = ?1")
	int findAllPrice(Long cartItemId);

	@Query("SELECT new ua.com.shop.entity.Commodity(c.id,c.name, count(c.name) AS repetitions, sum(c.price),c.price, c.version) "
			+ "FROM Commodity c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Commodity> findCommodityInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.Glove(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Glove c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Glove> findGloveInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.HoldersChalk(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM HoldersChalk c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<HoldersChalk> findHoldersChalkInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.MotherInLaw(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM MotherInLaw c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<MotherInLaw> findMotherinLawInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.ProductCare(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM ProductCare c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<ProductCare> findProductCaresInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.Sticker(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Sticker c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Sticker> findStickersInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.Tube(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Tube c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Tube> findTubeInCart(Long cartId);

	@Query("SELECT new ua.com.shop.entity.Chalk(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Chalk c JOIN c.cartItems ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Chalk> findChalkInCart(Long cartId);

}
