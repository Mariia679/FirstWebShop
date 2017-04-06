package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.dto.filter.ProductCareFilter;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.ChalkService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.GloveService;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.service.ReviewsService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;
import ua.com.shop.util.ParamBuilder;

@Controller
@RequestMapping("/productCare")
public class ProductCareUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ReviewsService reviewsService;

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

	@ModelAttribute("filter")
	public ProductCareFilter getFilter() {
		return new ProductCareFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@CookieValue(defaultValue = "0", name = "userId") Long id,
			@ModelAttribute("filter") ProductCareFilter filter) {
		model.addAttribute("page", productCareService.findAll(pageable, filter));
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
		return "user-productCare";
	}

	@GetMapping("/buy/{chalkId}")
	public String buy(Model model, @CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProductCareFilter filter) {
		userService.addToCartItemProductCare(userId, chalkId);
		return "redirect:/productCare" + getParams(pageable, filter);
	}

	@GetMapping("/details/{chalkId}")
	public String details(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProductCareFilter filter) {
		model.addAttribute("productCare", productCareService.findOne(chalkId));
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
		model.addAttribute("reviews", reviewsService.findByProductCare(chalkId));
		return "user-productCareCard";
	}

	@GetMapping("/toBascet/{chalkId}")
	public String toBascet(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProductCareFilter filter) {
		userService.addToCartItemProductCare(userId, chalkId);
		return "redirect:/productCare/details/{chalkId}";
	}

	private String getParams(Pageable pageable, ProductCareFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMax().isEmpty()) {
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if (!filter.getMin().isEmpty()) {
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		if (!filter.getNameProductCare().isEmpty()) {
			buffer.append("&name=");
			buffer.append(filter.getNameProductCare());
		}
		return buffer.toString();
	}
}
