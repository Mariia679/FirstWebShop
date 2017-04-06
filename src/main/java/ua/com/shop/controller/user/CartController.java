package ua.com.shop.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.ChalkFilter;
import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.filter.GloveFilter;
import ua.com.shop.dto.filter.HoldersChalkFilter;
import ua.com.shop.dto.filter.MotherInLawFilter;
import ua.com.shop.dto.filter.ProductCareFilter;
import ua.com.shop.dto.filter.StickerFilter;
import ua.com.shop.dto.filter.TubeFilter;
import ua.com.shop.entity.CartItem;
import ua.com.shop.entity.Chalk;
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
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.GloveService;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.service.OrderService;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;
import ua.com.shop.validator.UserValidator;

@Controller
public class CartController {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private UserService userService;

	@Autowired
	private TubeService tubeService;

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
	private OrderService orderService;

	@InitBinder("userForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}

	@RequestMapping("/user/cart")
	public String cartItem() {
		return "user-cart";
	}

	@GetMapping("/user/cart")
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
		return "user-cart";
	}

	@PostMapping("/user/cart")
	public String checkout(@ModelAttribute("userForm") User user,
			BindingResult br, Model model,
			@CookieValue(value = "userId") Long userId, SessionStatus status) {
		if (br.hasErrors())
			return "user-cart";
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
		orderService.save(order);
		userService.sendMail("ЗАКАЗ ТОВАРА", "ssandy679@gmail.com",
				user.getPhone() + " Номер заказа: " + order.getId() + " "
						+ order.toString());
		userService.deleteAll(userId);

		status.setComplete();
		return "redirect:/";
	}

	@GetMapping("/commodity/buy/{commodityId}")
	public String buyCommodity(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long commodityId) {
		userService.addToCartItem(userId, commodityId);

		return "redirect:/user/cart";
	}

	@GetMapping("/chalkBuy/buy/{chalkId}")
	public String buyChalk(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId) {
		userService.addToCartItemChalk(userId, chalkId);
		return "redirect:/user/cart";
	}

	@GetMapping("/tubeBuy/buy/{tubeId}")
	public String buyTube(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long tubeId) {
		userService.addToCartItemTube(userId, tubeId);
		return "redirect:/user/cart";
	}

	@GetMapping("/gloveBuy/buy/{gloveId}")
	public String buyGlove(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long gloveId) {
		userService.addToCartItemGlove(userId, gloveId);
		return "redirect:/user/cart";
	}

	@GetMapping("/holdersChalkBuy/buy/{chalkId}")
	public String buyHoldersChalk(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId) {
		userService.addToCartItemHoldersChalk(userId, chalkId);
		return "redirect:/user/cart";
	}

	@GetMapping("/motherInLawBuy/buy/{chalkId}")
	public String buyMotherInLaw(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId) {
		userService.addToCartItemMotherInLaw(userId, chalkId);
		return "redirect:/user/cart";
	}

	@GetMapping("/productCareBuy/buy/{chalkId}")
	public String buyProductCare(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId) {
		userService.addToCartItemProductCare(userId, chalkId);
		return "redirect:/user/cart";
	}

	@GetMapping("/stickerBuy/buy/{chalkId}")
	public String buySticker(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId) {
		userService.addToCartItemSticker(userId, chalkId);
		return "redirect:/user/cart";
	}

	@GetMapping("/commodity/del/{id}")
	public String deleteCommodity(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItem(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/cover/del/{id}")
	public String deleteTube(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemTube(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/chalk/del/{id}")
	public String deleteChalk(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemChalk(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/glove/del/{id}")
	public String deleteGlove(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemGlove(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/holdersChalk/del/{id}")
	public String deleteHoldersChalk(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemHoldersChalk(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/motherInLaw/del/{id}")
	public String deleteMotherInLaw(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemMotherInLaw(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/sticker/del/{id}")
	public String deleteSticker(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemSticker(userId, id);
		return "redirect:/user/cart";
	}

	@GetMapping("/productCare/del/{id}")
	public String deleteProductCare(Model model, @PathVariable Long id,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		userService.deleteToCartItemProductCare(userId, id);
		return "redirect:/user/cart";
	}
}
