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
import ua.com.shop.entity.Category;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.validator.CategoryValidator;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CartItemService cartItemService;

	@InitBinder("category")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CategoryValidator(categoryService));
	}

	@ModelAttribute("category")
	public Category getForm() {
		return new Category();
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("page", categoryService.findAll(filter, pageable));
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
		return "admin-category";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("category", categoryService.findOne(id));
		return show(model, pageable, filter, userId);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		commodityService.setNullCategory(id);
		categoryService.delete(id);
		return "redirect:/admin/category" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/category" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("category") @Valid Category category,
			BindingResult br, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId,
			SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter, userId);
		categoryService.save(category);
		status.setComplete();
		return "redirect:/admin/category" + getParams(pageable, filter);
	}

}
