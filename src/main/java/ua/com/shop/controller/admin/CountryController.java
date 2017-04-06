package ua.com.shop.controller.admin;

import static ua.com.shop.util.ParamBuilder.getParams;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CityService;
import ua.com.shop.service.CountryService;
import ua.com.shop.validator.CountryValidator;

@Controller
@RequestMapping("/admin/country")
@SessionAttributes("country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private CityService cityService;
	@Autowired
	private CartItemService cartItemService;

	@InitBinder("country")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CountryValidator(countryService));
	}

	@ModelAttribute("country")
	public Country getForm() {
		return new Country();
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("page", countryService.findAll(filter, pageable));
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
		return "admin-country";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("country", countryService.findOne(id));
		return show(model, pageable, filter,userId);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		countryService.delete(id);
		return "redirect:/admin/country" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter, SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/country" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("country") @Valid Country country,
			BindingResult br, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId, SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter,userId);
		countryService.save(country);
		status.setComplete();
		return "redirect:/admin/country" + getParams(pageable, filter);

	}
}
