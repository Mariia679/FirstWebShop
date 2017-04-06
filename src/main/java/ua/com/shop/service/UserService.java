package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.User;

public interface UserService {

	void save(User t);

	// void delete(Long id);

	Long createNewUser();

	void sendMail(String content, String email, String mailBody);

	void addToCartItem(Long userId, Long commodityId);

	void deleteToCartItem(Long userId, Long commodityId);

	User findByEmail(String email);

	User findByUsername(String username);

	User findUnique(String email, String username);

	User findById(Long id);

	void addToCartItemTube(Long userId, Long tubeId);

	void deleteToCartItemTube(Long userId, Long tubeId);

	void addToCartItemChalk(Long userId, Long chalkId);

	void deleteToCartItemChalk(Long userId, Long chalkId);

	void addToCartItemGlove(Long userId, Long gloveId);

	void deleteToCartItemGlove(Long userId, Long gloveId);

	void addToCartItemHoldersChalk(Long userId, Long holdersChalkId);

	void deleteToCartItemHoldersChalk(Long userId, Long holdersChalkId);

	void addToCartItemMotherInLaw(Long userId, Long motherInLawId);

	void deleteToCartItemMotherInLaw(Long userId, Long motherInLawId);

	void addToCartItemProductCare(Long userId, Long productCareId);

	void deleteToCartItemProductCare(Long userId, Long productCareId);

	void addToCartItemSticker(Long userId, Long stickerId);

	void deleteToCartItemSticker(Long userId, Long stickerId);

	void setNameToUser(String username, Long userId);

	void saveCheckout(User user);

	void deleteAll(Long userId);

}
