package ua.com.shop.controller.admin;

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

import ua.com.shop.dto.filter.CityFilter;
import ua.com.shop.editor.CountryEditor;
import ua.com.shop.entity.City;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CityService;
import ua.com.shop.service.CountryService;
import ua.com.shop.service.NewMailService;
import ua.com.shop.service.UkrMailService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.CityValidator;

@Controller
@RequestMapping("/admin/city")
@SessionAttributes(names = "city")
public class CityController {

	@Autowired
	private CityService cityService;

	@Autowired
	private CountryService countryServise;

	@Autowired
	private UkrMailService ukrMailService;

	@Autowired
	private NewMailService newMailService;
	
	@Autowired
	private CartItemService cartItemService;

	@InitBinder("city")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, new CountryEditor(
				countryServise));
		binder.setValidator(new CityValidator(cityService));
	}

	@ModelAttribute("city")
	public City getForm() {
		return new City();
	}

	@ModelAttribute("filter")
	public CityFilter getFilter() {
		return new CityFilter();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CityFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("page", cityService.findAll(filter, pageable));
		model.addAttribute("countries", countryServise.findAll());
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
		return "admin-city";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") CityFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("city", cityService.findOne(id));
		return show(model, pageable, filter,userId);
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") CityFilter filter) {
		ukrMailService.setNullUkrMail(id);
		newMailService.setNullNewMail(id);
		cityService.delete(id);
		return "redirect:/admin/city" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") CityFilter filter, SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/city" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("city") @Valid City city,
			BindingResult br, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CityFilter filter, @CookieValue(defaultValue = "0", name = "userId") Long userId,SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter,userId);
		cityService.save(city);
		status.setComplete();
		return "redirect:/admin/city" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, CityFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getNameCity().isEmpty()) {
			buffer.append("&name=");
			buffer.append(filter.getNameCity());
		}
		if (!filter.getCountryId().isEmpty()) {
			for (Long id : filter.getCountryId()) {
				buffer.append("&countryId=");
				buffer.append(id);
			}
		}

		return buffer.toString();
	}

}
