package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.CartItem;
import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;

public interface CartItemService {

	void save(CartItem t);

	List<CartItem> findAll();

	CartItem findOne(Long id);

	void delete(Long id);

	Long findByUserId(Long userId);

	Commodity findByCommodityId(Long id2);

	int findAllPrice(Long cartItemId);

	List<Commodity> findCommodityInCart(Long cartItemId);

	List<Chalk> findChalkInCart(Long cartId);

	List<Tube> findTubeInCart(Long cartId);

	List<Sticker> findStickersInCart(Long cartId);

	List<ProductCare> findProductCaresInCart(Long cartId);

	List<MotherInLaw> findMotherinLawInCart(Long cartId);

	List<HoldersChalk> findHoldersChalkInCart(Long cartId);

	List<Glove> findGloveInCart(Long cartId);
}
