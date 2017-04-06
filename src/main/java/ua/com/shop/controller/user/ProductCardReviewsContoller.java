package ua.com.shop.controller.user;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.entity.Reviews;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.ChalkService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.GloveService;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.service.ProductDescriptionService;
import ua.com.shop.service.ReviewsService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;

@Controller
public class ProductCardReviewsContoller {

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

	@Autowired
	private ProductDescriptionService productDescriptionService;

	@ModelAttribute("filter")
	public CommodityFilter getFilter() {
		return new CommodityFilter();
	}

	@ModelAttribute("review")
	public Reviews getForm() {
		return new Reviews();
	}

	@GetMapping("/allProducts/details/{commodityId}")
	public String details(Model model,
			@CookieValue(value = "userId") Long userId,
			@PathVariable Long commodityId, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter) {
		model.addAttribute("productDescriptions",
				productDescriptionService.findAll());
		model.addAttribute("commodity", commodityService.findOne(commodityId));
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
		model.addAttribute("reviews",
				reviewsService.findByCommodity(commodityId));
		commodityService.countByPopular(commodityId);

		return "user-productCard";
	}

	@PostMapping("/user/productCard/{commodityId}")
	public String save(Model model, @CookieValue(value = "userId") Long userId,
			@PathVariable Long commodityId, @RequestParam String name,
			@RequestParam String review, Principal principal) {
		Date date = new Date();
		User user;
		if (principal != null) {
			user = userService.findByUsername(principal.getName());
		} else {
			user = userService.findById(userId);
			// user.setName(name);
			userService.setNameToUser(name, userId);
		}
		Reviews reviews = new Reviews();
		reviews.setCommodity(commodityService.findOne(commodityId));
		reviews.setDate(date);
		reviews.setUser(user);
		reviews.setReview(review);
		reviewsService.save(reviews);
		return "redirect:/allProducts/details/{commodityId}";
	}

	@GetMapping("/user/productCard/cancel/{commodityId}")
	public String cancel(@PageableDefault Pageable pageable,
			@PathVariable Long commodityId, SessionStatus status) {
		status.setComplete();
		return "redirect:/allProducts/details/{commodityId}";
	}

	@RequestMapping("/user/productCard/delete/{id}/{commodityId}")
	public String delete(@PathVariable Long id, @PathVariable Long commodityId,
			SessionStatus status) {
		reviewsService.delete(id);
		status.setComplete();
		return "redirect:/allProducts/details/{commodityId}";
	}

	@RequestMapping("/user/productCard/update/{id}/{commodityId}")
	public String update(@PathVariable Long id, @PathVariable Long commodityId,
			Model model, @CookieValue(value = "userId") Long userId,
			Principal principal, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter,
			SessionStatus status) {
		model.addAttribute("review", reviewsService.findOne(id));
		status.setComplete();
		return "redirect:/allProducts/details/{commodityId}";
	}

}
