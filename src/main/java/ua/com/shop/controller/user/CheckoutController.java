package ua.com.shop.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.CityEditor;
import ua.com.shop.entity.CartItem;
import ua.com.shop.entity.Chalk;
import ua.com.shop.entity.City;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Glove;
import ua.com.shop.entity.HoldersChalk;
import ua.com.shop.entity.MotherInLaw;
import ua.com.shop.entity.Order;
import ua.com.shop.entity.ProductCare;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.Tube;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.ChalkService;
import ua.com.shop.service.CityService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.GloveService;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.service.NewMailService;
import ua.com.shop.service.OrderService;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;
import ua.com.shop.validator.UserValidator;

@Controller
@RequestMapping("/checkout")
@SessionAttributes("userForm")
public class CheckoutController {

	@Autowired
	private UserService userService;

	@Autowired
	private TubeService tubeService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private ChalkService chalkService;

	@Autowired
	private GloveService gloveService;

	@Autowired
	private HoldersChalkService holdersChalkService;

	@Autowired
	private MotherInLawService motherInLawService;

	@Autowired
	private ProductCareService productCareService;

	@Autowired
	private StickerService stickerService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CityService cityService;

	@Autowired
	private NewMailService newMailService;

	@Autowired
	private OrderService orderService;

	@InitBinder("userForm")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(City.class, new CityEditor(cityService));
		binder.setValidator(new UserValidator(userService));
	}

	@GetMapping
	public String show(Model model,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		Long cartId = cartItemService.findByUserId(userId);
		model.addAttribute("commodities",
				cartItemService.findCommodityInCart(cartId));
		model.addAttribute("tubes", cartItemService.findTubeInCart(cartId));
		model.addAttribute("chalks", cartItemService.findChalkInCart(cartId));
		model.addAttribute("stickers",
				cartItemService.findStickersInCart(cartId));
		model.addAttribute("productCares",
				cartItemService.findProductCaresInCart(cartId));
		model.addAttribute("motherInLaws",
				cartItemService.findMotherinLawInCart(cartId));
		model.addAttribute("holdersChalks",
				cartItemService.findHoldersChalkInCart(cartId));
		model.addAttribute("gloves", cartItemService.findGloveInCart(cartId));
		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("userForm", new User());
		if (commodityService.findByUserId(userId) != null
				|| tubeService.findByUserId(userId) != null
				|| chalkService.findByUserId(userId) != null
				|| stickerService.findByUserId(userId) != null
				|| productCareService.findByUserId(userId) != null
				|| motherInLawService.findByUserId(userId) != null
				|| holdersChalkService.findByUserId(userId) != null
				|| gloveService.findByUserId(userId) != null) {
			model.addAttribute("cartItemPrice",
					cartItemService.findAllPrice(cartId));
		}
		return "user-checkout";
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/checkout";
	}

	@PostMapping
	public String checkout(@ModelAttribute("userForm") User user,
			BindingResult br, Model model,
			@CookieValue(value = "userId") Long userId, SessionStatus status) {
		if (br.hasErrors())
			return "user-checkout";
		user.setId(userId);
		Long cartId = cartItemService.findByUserId(userId);
		CartItem cart = cartItemService.findOne(cartId);
		user.setCartItem(cart);
		Order order = new Order();
		List<Commodity> comm = commodityService.findByUserId(userId);
		List<Tube> tubes = tubeService.findByUserId(userId);
		List<Chalk> chalks = chalkService.findByUserId(userId);
		List<Sticker> stickers = stickerService.findByUserId(userId);
		List<ProductCare> pCares = productCareService.findByUserId(userId);
		List<MotherInLaw> motherInLaws = motherInLawService
				.findByUserId(userId);
		List<HoldersChalk> holdersChalks = holdersChalkService
				.findByUserId(userId);
		List<Glove> gloves = gloveService.findByUserId(userId);
		order.setGloves(gloves);
		order.setHoldersChalks(holdersChalks);
		order.setMotherInLaws(motherInLaws);
		order.setProductCares(pCares);
		order.setCommodities(comm);
		order.setTubes(tubes);
		order.setChalks(chalks);
		order.setStickers(stickers);
		order.setUser(user);
		order.setPrice(cartItemService.findAllPrice(cartId));
		orderService.save(order);
		// userService.saveCheckout(user);
		userService.sendMail(
				"ЗАКАЗ ТОВАРА",
				"ssandy679@gmail.com",
				user.getName() + " " + user.getSurname() + " "
						+ user.getPhone() + " Номер заказа: " + order.getId()
						+ " Отделение НП " + user.getMail() + " Город "
						+ user.getCity().toString() + " E-mail "
						+ user.getEmail());

		userService
				.sendMail(
						"Номер заказа",
						user.getEmail(),
						"НОМЕР ВАШЕГО ЗАКАЗА "
								+ order.getId()
								+ "\n Сумма: "
								+ cartItemService.findAllPrice(cartId)
								+ ".\n В ближайщее время с вами свяжется наш менеджер. Хорошего времени суток!!! ");
		userService.deleteAll(userId);
		status.setComplete();
		return "redirect:/checkout";
	}
}
