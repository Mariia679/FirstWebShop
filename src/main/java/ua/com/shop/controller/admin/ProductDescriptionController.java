package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.editor.CommodityEditor;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.ProductDescription;
import ua.com.shop.entity.User;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.ProductDescriptionService;

@Controller
@RequestMapping("/admin/productDescription")
@SessionAttributes("productDescription")
public class ProductDescriptionController {

	@Autowired
	private ProductDescriptionService productDescriptionService;

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CartItemService cartItemService;

	@InitBinder("productDescription")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(
				commodityService));
	}

	@ModelAttribute("productDescription")
	public ProductDescription getForm() {
		return new ProductDescription();
	}

	@GetMapping
	public String show(Model model,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("productDescriptions",
				productDescriptionService.findAll());
		model.addAttribute("commodities", commodityService.findAll());
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
		return "admin-productDescription";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("productDescription",
				productDescriptionService.findOne(id));
		return show(model,userId);
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		productDescriptionService.delete(id);
		return "redirect:/admin/productDescription";
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/productDescription";
	}

	@PostMapping
	public String save(
			@ModelAttribute("productDescription") ProductDescription productDescription,
			BindingResult br, Model model,@CookieValue(defaultValue = "0", name = "userId") Long userId, SessionStatus status) {
		if (br.hasErrors())
			return show(model,userId);

		productDescriptionService.save(productDescription);

		status.setComplete();
		return "redirect:/admin/productDescription";

	}
}
