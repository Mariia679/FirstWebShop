package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.entity.CartItem;
import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;
import ua.com.shop.repository.CartItemRepository;
import ua.com.shop.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	public void save(CartItem t) {
		cartItemRepository.save(t);
	}

	public List<CartItem> findAll() {
		return cartItemRepository.findAll();
	}

	public CartItem findOne(Long id) {
		return cartItemRepository.findOne(id);
	}

	public void delete(Long id) {
		cartItemRepository.delete(id);
	}

	@Override
	public Commodity findByCommodityId(Long cartItemId) {
		return cartItemRepository.findByCommodity(cartItemId);
	}

	public Long findByUserId(Long userId) {
		return cartItemRepository.findByUserId(userId);
	}

	@Override
	public int findAllPrice(Long cartItemId) {
		return cartItemRepository.findAllPrice(cartItemId);
	}

	@Override
	public List<Commodity> findCommodityInCart(Long cartItemId) {
		return cartItemRepository.findCommodityInCart(cartItemId);
	}

	@Override
	public List<Chalk> findChalkInCart(Long cartId) {
		return cartItemRepository.findChalkInCart(cartId);
	}

	@Override
	public List<Tube> findTubeInCart(Long cartId) {
		return  cartItemRepository.findTubeInCart(cartId);
	}

	@Override
	public List<Sticker> findStickersInCart(Long cartId) {
		return cartItemRepository.findStickersInCart(cartId);
	}

	@Override
	public List<ProductCare> findProductCaresInCart(Long cartId) {
		return cartItemRepository.findProductCaresInCart(cartId);
	}

	@Override
	public List<MotherInLaw> findMotherinLawInCart(Long cartId) {
		return cartItemRepository.findMotherinLawInCart(cartId);
	}

	@Override
	public List<HoldersChalk> findHoldersChalkInCart(Long cartId) {
		return cartItemRepository.findHoldersChalkInCart(cartId);
	}

	@Override
	public List<Glove> findGloveInCart(Long cartId) {
		return cartItemRepository.findGloveInCart(cartId);
	}

}
