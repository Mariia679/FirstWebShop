package ua.com.shop.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Commodity;
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
import ua.com.shop.service.ReviewsService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;
import ua.com.shop.service.WoodService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private UserService userService;

	@Autowired
	private CommodityService commodityService;

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

	@GetMapping
	public String show(Model model,
			@CookieValue(defaultValue = "0", name = "userId") Long id) {
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

		return "user-contact";
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/contact";
	}

	@PostMapping
	public String registration(@RequestParam String username,
			@RequestParam String email, @RequestParam String review,
			SessionStatus status) {
		userService.sendMail("Вопрос от " + username + " " + email,
				"ssandy679@gmail.com", review);
		status.setComplete();
		return "redirect:/contact";
	}
}
