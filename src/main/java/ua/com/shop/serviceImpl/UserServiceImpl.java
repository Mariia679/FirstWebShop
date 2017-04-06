package ua.com.shop.serviceImpl;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.entity.CartItem;
import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Role;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;
import ua.com.shop.entity.User;
import ua.com.shop.repository.CartItemRepository;
import ua.com.shop.repository.ChalkRepository;
import ua.com.shop.repository.CommodityRepository;
import ua.com.shop.repository.GloveRepository;
import ua.com.shop.repository.HoldersChalkRepository;
import ua.com.shop.repository.MotherInLawRepository;
import ua.com.shop.repository.ProductCareRepository;
import ua.com.shop.repository.StickerRepository;
import ua.com.shop.repository.TubeRepository;
import ua.com.shop.repository.UserRepository;
import ua.com.shop.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommodityRepository commodityRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private TubeRepository tubeRepository;

	@Autowired
	private ChalkRepository chalkRepository;

	@Autowired
	private GloveRepository gloveRepository;

	@Autowired
	private HoldersChalkRepository holdersChalkRepository;

	@Autowired
	private ProductCareRepository productCareRepository;

	@Autowired
	private StickerRepository stickerRepository;

	@Autowired
	private MotherInLawRepository motherInLawRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public void sendMail(String content, String email, String mailBody) {
		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"E-MAIL", "PASSWORD");
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("E-MAIL"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					email));
			message.setSubject(content, "UTF-8");
			message.setText(mailBody);
			Transport.send(message);
		} catch (MessagingException е) {
			е.printStackTrace();
		}
	}

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		CartItem cart = cartItemRepository.saveAndFlush(new CartItem());
		user.setCartItem(cart);
		userRepository.save(user);
	}

	@Override
	public void saveCheckout(User user) {
		userRepository.updateUser(user.getName(), user.getSurname(),
				user.getEmail(), user.getPhone(), user.getId());

	}

	@PostConstruct
	public void admin() {
		User user = userRepository.findByUsername("admin");
		if (user == null) {
			user = new User();
			user.setEmail("");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			user.setUsername("admin");
			userRepository.save(user);
		}
	}

	public Long createNewUser() {
		User user = new User();
		CartItem cart = cartItemRepository.saveAndFlush(new CartItem());
		user.setCartItem(cart);
		userRepository.saveAndFlush(user);
		Long id = user.getId();
		return id;

	}

	// Add to cartItem and delete from CartItem

	@Transactional
	public void addToCartItem(Long userId, Long commodityId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		Commodity commodity = commodityRepository.findOne(commodityId);
		cart.addCommodity(commodity);
	}

	@Transactional
	public void deleteToCartItem(Long userId, Long commodityId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		Commodity commodity = commodityRepository.findOne(commodityId);
		cart.deleteCommodity(commodity);
	}
	@Transactional
	public void deleteAll(Long userId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		cart.deleteAll();
	}
	@Transactional
	public void addToCartItemTube(Long userId, Long tubeId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		Tube tube = tubeRepository.findOne(tubeId);
		cart.addTube(tube);
	}

	@Transactional
	public void deleteToCartItemTube(Long userId, Long tubeId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		Tube tube = tubeRepository.findOne(tubeId);
		cart.deleteTube(tube);
	}

	@Transactional
	public void addToCartItemChalk(Long userId, Long chalkId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		Chalk chalk = chalkRepository.findOne(chalkId);
		cart.addChalk(chalk);
	}

	@Transactional
	public void deleteToCartItemChalk(Long userId, Long chalkId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		Chalk chalk = chalkRepository.findOne(chalkId);
		cart.deleteChalk(chalk);
	}

	@Transactional
	public void addToCartItemGlove(Long userId, Long gloveId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		Glove glove = gloveRepository.findOne(gloveId);
		cart.addGlove(glove);
	}

	@Transactional
	public void deleteToCartItemGlove(Long userId, Long gloveId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		Glove glove = gloveRepository.findOne(gloveId);
		cart.deleteGlove(glove);
	}

	@Transactional
	public void addToCartItemHoldersChalk(Long userId, Long holdersChalkId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		HoldersChalk holdersChalk = holdersChalkRepository
				.findOne(holdersChalkId);
		cart.addHoldersChalk(holdersChalk);
	}

	@Transactional
	public void deleteToCartItemHoldersChalk(Long userId, Long holdersChalkId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		HoldersChalk holdersChalk = holdersChalkRepository
				.findOne(holdersChalkId);
		cart.deleteHoldersChalk(holdersChalk);
	}

	@Transactional
	public void addToCartItemMotherInLaw(Long userId, Long motherInLawId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		MotherInLaw motherInLaw = motherInLawRepository.findOne(motherInLawId);
		cart.addMotherInLaw(motherInLaw);
	}

	@Transactional
	public void deleteToCartItemMotherInLaw(Long userId, Long motherInLawId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		MotherInLaw motherInLaw = motherInLawRepository.findOne(motherInLawId);
		cart.deleteMotherInLaw(motherInLaw);
	}

	@Transactional
	public void addToCartItemProductCare(Long userId, Long productCareId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		ProductCare productCare = productCareRepository.findOne(productCareId);
		cart.addProductCare(productCare);
	}

	@Transactional
	public void deleteToCartItemProductCare(Long userId, Long productCareId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		ProductCare productCare = productCareRepository.findOne(productCareId);
		cart.deleteProductCare(productCare);
	}

	@Transactional
	public void addToCartItemSticker(Long userId, Long stickerId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		if (cart == null) {
			cart = cartItemRepository.save(new CartItem());
			user.setCartItem(cart);
		}
		Sticker sticker = stickerRepository.findOne(stickerId);
		cart.addSticker(sticker);
	}

	@Transactional
	public void deleteToCartItemSticker(Long userId, Long stickerId) {
		User user = userRepository.findOne(userId);
		CartItem cart = user.getCartItem();
		Sticker sticker = stickerRepository.findOne(stickerId);
		cart.deleteSticker(sticker);
	}

	// Method used for validation

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUnique(String email, String username) {
		return userRepository.findUnique(email, username);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

	// Setter
	public void setTubeRepository(TubeRepository tubeRepository) {
		this.tubeRepository = tubeRepository;
	}

	public void setChalkRepository(ChalkRepository chalkRepository) {
		this.chalkRepository = chalkRepository;
	}

	public void setGloveRepository(GloveRepository gloveRepository) {
		this.gloveRepository = gloveRepository;
	}

	public void setHoldersChalkRepository(
			HoldersChalkRepository holdersChalkRepository) {
		this.holdersChalkRepository = holdersChalkRepository;
	}

	public void setProductCareRepository(
			ProductCareRepository productCareRepository) {
		this.productCareRepository = productCareRepository;
	}

	public void setStickerRepository(StickerRepository stickerRepository) {
		this.stickerRepository = stickerRepository;
	}

	public void setCartItemRepository(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setCommodityRepository(CommodityRepository commodityRepository) {
		this.commodityRepository = commodityRepository;
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public void setNameToUser(String username, Long userId) {
		userRepository.setNameToUser(username, userId);

	}

}
