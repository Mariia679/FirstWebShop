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

import ua.com.shop.dto.filter.GloveFilter;
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
@RequestMapping("gloves")
public class GlovesUserContoller {

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
	public GloveFilter getFilter() {
		return new GloveFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@CookieValue(defaultValue = "0", name = "userId") Long id,
			@ModelAttribute("filter") GloveFilter filter) {
		model.addAttribute("page", gloveService.findAll(pageable, filter));
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
		return "user-gloves";
	}

	@GetMapping("/buy/{gloveId}")
	public String buy(Model model, @CookieValue(value = "userId") Long userId,
			@PathVariable Long gloveId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") GloveFilter filter) {
		userService.addToCartItemGlove(userId, gloveId);
		return "redirect:/gloves" + getParams(pageable, filter);
	}

	@GetMapping("/details/{gloveId}")
	public String details(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long gloveId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") GloveFilter filter) {
		model.addAttribute("glove", gloveService.findOne(gloveId));
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
		model.addAttribute("reviews", reviewsService.findByGloves(gloveId));
		return "user-gloveCard";
	}

	@GetMapping("/toBascet/{gloveId}")
	public String toBascet(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long gloveId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") GloveFilter filter) {
		userService.addToCartItemGlove(userId, gloveId);
		return "redirect:/gloves/details/{gloveId}";
	}

	private String getParams(Pageable pageable, GloveFilter filter) {
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
		if (!filter.getNameGlove().isEmpty()) {
			buffer.append("&name=");
			buffer.append(filter.getNameGlove());
		}
		return buffer.toString();
	}
}
