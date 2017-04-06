package ua.com.shop.controller.user;

import java.security.Principal;

import javax.validation.Valid;

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

import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.ChalkService;
import ua.com.shop.service.CityService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.CountryService;
import ua.com.shop.service.GloveService;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.MotherInLawService;
import ua.com.shop.service.ProductCareService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TubeService;
import ua.com.shop.service.UserService;
import ua.com.shop.validator.UserValidator;

@Controller
@RequestMapping("/registration")
@SessionAttributes("userForm")
public class RegistrationUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CityService cityService;

	@Autowired
	private CountryService countryService;

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


	@InitBinder("form")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/user/registration";
	}

	@GetMapping
	public String registration(Model model,
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
		model.addAttribute("form", new User());
		return "user-registration";
	}

	@PostMapping
	public String registration(@ModelAttribute("form") @Valid User user,
			BindingResult br, Model model,
			@CookieValue(defaultValue = "0", name = "userId") Long id,
			Principal principal, SessionStatus status) {
		if (br.hasErrors())
			return "user-registration";
		user.setId(id);
		userService.save(user);
		userService.sendMail("Подтверждение регистрации", user.getEmail(),
				"Для подтверждения регистрации пройдите по такой ссылке....");
		status.setComplete();
		return "redirect:/login";
	}

}
