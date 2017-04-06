package ua.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.Order;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;

public interface OrderRepository extends JpaRepository<Order, Long>,
		JpaSpecificationExecutor<Order> {

	@Query("SELECT new ua.com.shop.entity.Commodity(c.id,c.name, count(c.name) AS repetitions, sum(c.price),c.price, c.version) "
			+ "FROM Commodity c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Commodity> findCommodityInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.Glove(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Glove c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Glove> findGloveInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.HoldersChalk(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM HoldersChalk c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<HoldersChalk> findHoldersChalkInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.MotherInLaw(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM MotherInLaw c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<MotherInLaw> findMotherinLawInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.ProductCare(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM ProductCare c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<ProductCare> findProductCaresInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.Sticker(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Sticker c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Sticker> findStickersInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.Tube(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Tube c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Tube> findTubeInOrder(Long orderId);

	@Query("SELECT new ua.com.shop.entity.Chalk(c.id,c.name, count(c.name) AS repetitions, sum(c.price), c.price, c.version) "
			+ "FROM Chalk c JOIN c.order ci WHERE ci.id = ?1 GROUP BY c.name,c.price,c.version,c.id")
	List<Chalk> findChalkInOrder(Long orderId);

}
