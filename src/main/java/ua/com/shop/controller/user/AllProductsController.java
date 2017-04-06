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

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ChalkService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.GashTypeService;
import ua.com.shop.service.GloveService;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.service.ProductDescriptionService;
import ua.com.shop.service.ReviewsService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;
import ua.com.shop.service.WoodService;
import ua.com.shop.util.ParamBuilder;

@Controller
@RequestMapping("/allProducts")
public class AllProductsController {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private UserService userService;

	@Autowired
	private WoodService woodService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private GashTypeService gashTypeService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ReviewsService reviewsService;

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
	private ProductDescriptionService productDescriptionService;

	@ModelAttribute("filter")
	public CommodityFilter getFilter() {
		return new CommodityFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long id) {
		model.addAttribute("page", commodityService.findAll(pageable, filter));
		model.addAttribute("woods", woodService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("gashTypes", gashTypeService.findAll());

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

		return "user-allProducts";
	}

	@GetMapping("/buy/{commodityId}")
	public String buy(Model model, @CookieValue(value = "userId") Long userId,
			@PathVariable Long commodityId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter) {
		userService.addToCartItem(userId, commodityId);

		return "redirect:/allProducts" + getParams(pageable, filter);
	}

	@GetMapping("/toBascet/{commodityId}")
	public String toBascet(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long commodityId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter) {
		userService.addToCartItem(userId, commodityId);
		return "redirect:/allProducts/details/{commodityId}";
	}

	private String getParams(Pageable pageable, CommodityFilter filter) {
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
		if (!filter.getNameCommodity().isEmpty()) {
			buffer.append("&name=");
			buffer.append(filter.getNameCommodity());
		}

		if (!filter.getWoodId().isEmpty()) {
			for (Long id : filter.getWoodId()) {
				buffer.append("&woodId=");
				buffer.append(id);
			}
		}

		if (!filter.getCategoryId().isEmpty()) {
			for (Long id : filter.getCategoryId()) {
				buffer.append("&categoryId=");
				buffer.append(id);
			}
		}
		if (!filter.getGashTypeId().isEmpty()) {
			for (Long id : filter.getGashTypeId()) {
				buffer.append("&gashTypeId=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
}
