package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.Order;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;

public interface OrderService {

	void save(Order order);

	List<Order> findAll();

	Order findOne(Long orderId);

	List<Glove> findGloveInOrder(Long orderId);

	List<Commodity> findCommodityInOrder(Long orderId);

	List<Tube> findTubeInOrder(Long orderId);

	List<Chalk> findChalkInOrder(Long orderId);

	List<HoldersChalk> findHoldersChalkInOrder(Long orderId);

	List<MotherInLaw> findMotherinLawInOrder(Long orderId);

	List<ProductCare> findProductCaresInOrder(Long orderId);

	List<Sticker> findStickersInOrder(Long orderId);


}
