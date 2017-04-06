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

import ua.com.shop.dto.filter.UkrMailFilter;
import ua.com.shop.editor.CityEditor;
import ua.com.shop.entity.City;
import ua.com.shop.entity.UkrMail;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CityService;
import ua.com.shop.service.UkrMailService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.UkrMailValidator;

@Controller
@RequestMapping("/admin/ukrMail")
@SessionAttributes("ukrMail")
public class UkrMailController {

	@Autowired
	private UkrMailService mailService;

	@Autowired
	private CityService cityService;

	@Autowired
	private CartItemService cartItemService;

	@InitBinder("ukrMail")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(City.class, new CityEditor(cityService));
		binder.setValidator(new UkrMailValidator(mailService));
	}

	@ModelAttribute("ukrMail")
	public UkrMail getForm() {
		return new UkrMail();
	}

	@ModelAttribute("filter")
	public UkrMailFilter getFilter() {
		return new UkrMailFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") UkrMailFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("page", mailService.findAll(filter, pageable));
		model.addAttribute("cities", cityService.findAll());
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
		return "admin-ukrMail";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UkrMailFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("ukrMail", mailService.findOne(id));
		return show(model, pageable, filter, userId);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UkrMailFilter filter,
			@PathVariable Long id) {
		mailService.delete(id);
		return "redirect:/admin/ukrMail" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UkrMailFilter filter, SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/ukrMail" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("ukrMail") @Valid UkrMail entity,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UkrMailFilter filter, BindingResult br,
			Model model,
			@CookieValue(defaultValue = "0", name = "userId") Long userId,
			SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter, userId);
		mailService.save(entity);
		status.setComplete();
		return "redirect:/admin/ukrMail" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, UkrMailFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getDepartmentMail().isEmpty()) {
			buffer.append("&department=");
			buffer.append(filter.getDepartmentMail());
		}
		if (!filter.getCityId().isEmpty()) {
			for (Long id : filter.getCityId()) {
				buffer.append("&cityId=");
				buffer.append(id);
			}
		}

		return buffer.toString();
	}
}
