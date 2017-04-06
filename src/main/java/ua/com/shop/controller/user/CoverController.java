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

import ua.com.shop.dto.filter.TubeFilter;
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
@RequestMapping("/cover")
public class CoverController {

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
	public TubeFilter getFilter() {
		return new TubeFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@CookieValue(defaultValue = "0", name = "userId") Long id,
			@ModelAttribute("filter") TubeFilter filter) {
		model.addAttribute("page", tubeService.findAll(pageable, filter));
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
		return "user-cover";
	}

	@GetMapping("/buy/{tubeId}")
	public String buy(Model model, @CookieValue(value = "userId") Long userId,
			@PathVariable Long tubeId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") TubeFilter filter) {
		userService.addToCartItemTube(userId, tubeId);
		return "redirect:/cover" + getParams(pageable, filter);
	}

	@GetMapping("/details/{tubeId}")
	public String details(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long tubeId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") TubeFilter filter) {
		model.addAttribute("tube", tubeService.findOne(tubeId));
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
		model.addAttribute("reviews", reviewsService.findByTube(tubeId));
		return "user-tubeCard";
	}

	@GetMapping("/toBascet/{tubeId}")
	public String toBascet(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long tubeId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") TubeFilter filter) {
		userService.addToCartItemTube(userId, tubeId);
		return "redirect:/cover/details/{tubeId}";
	}

	private String getParams(Pageable pageable, TubeFilter filter) {
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
		if (!filter.getNameTube().isEmpty()) {
			buffer.append("&name=");
			buffer.append(filter.getNameTube());
		}
		return buffer.toString();
	}

}
