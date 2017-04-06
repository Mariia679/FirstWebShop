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
import ua.com.shop.entity.MainPage;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.MainPageService;
import ua.com.shop.validator.MainPageValidator;

@Controller
@RequestMapping("/admin/mainPage")
@SessionAttributes("mainPage")
public class MainPageController {

	@Autowired
	private MainPageService mainPageService;
	
	@Autowired
	private CartItemService cartItemService;

	@InitBinder("mainPage")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MainPageValidator(mainPageService));
	}

	@ModelAttribute("mainPage")
	public MainPage getForm() {
		return new MainPage();
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("page", mainPageService.findAll(filter, pageable));
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
		return "admin-mainPage";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("mainPage", mainPageService.findOne(id));
		return show(model, pageable, filter,userId);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		mainPageService.delete(id);
		return "redirect:/admin/mainPage" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter, SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/mainPage" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("mainPage") @Valid MainPage mainPage,
			BindingResult br, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,@CookieValue(defaultValue = "0", name = "userId") Long userId, SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter,userId);

		mainPageService.save(mainPage);
		status.setComplete();
		return "redirect:/admin/mainPage" + getParams(pageable, filter);
	}
}
