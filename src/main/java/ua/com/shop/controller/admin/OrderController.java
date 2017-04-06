package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

@Controller
public class OrderController {

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

	// @ModelAttribute("filter")
	// public OrderFilter getFilter() {
	// return new OrderFilter();
	// }

	@GetMapping("/admin/order")
	public String show(Model model,
			@CookieValue(defaultValue = "0", name = "userId") Long id) {
		model.addAttribute("orders", orderService.findAll());

		Long cartId = cartItemService.findByUserId(id);
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
		return "admin-order";
	}

	@RequestMapping("/admin/order/update/{orderId}")
	public String update(@PathVariable Long orderId, Model model,
			@CookieValue(defaultValue = "0", name = "userId") Long id) {
		model.addAttribute("order", orderService.findOne(orderId));
		model.addAttribute("commodity",
				orderService.findCommodityInOrder(orderId));
		model.addAttribute("tube", orderService.findTubeInOrder(orderId));
		model.addAttribute("chalk", orderService.findChalkInOrder(orderId));
		model.addAttribute("sticker",
				orderService.findStickersInOrder(orderId));
		model.addAttribute("productCare",
				orderService.findProductCaresInOrder(orderId));
		model.addAttribute("motherInLaw",
				orderService.findMotherinLawInOrder(orderId));
		model.addAttribute("holdersChalk",
				orderService.findHoldersChalkInOrder(orderId));
		model.addAttribute("glove", orderService.findGloveInOrder(orderId));

		Long cartId = cartItemService.findByUserId(id);
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
		return "admin-orderBy";
	}
	//
	// @GetMapping("/admin/orderBy/{id}")
	// public String showOrder(Model model, @PathVariable Long id) {
	//
	// return "redirect:/admin/orderBy/{id}";
	// }
}
