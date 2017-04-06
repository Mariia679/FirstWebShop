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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.dto.form.StickerForm;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.StickerService;
import ua.com.shop.validator.StickerValidator;

@Controller
@RequestMapping("/admin/sticker")
@SessionAttributes("sticker")
public class StickerController {

	@Autowired
	private StickerService stickerService;

	@Autowired
	private CommodityService commodityService;

	@InitBinder("sticker")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StickerValidator(stickerService));
	}

	@ModelAttribute("sticker")
	public StickerForm getForm() {
		return new StickerForm();
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", stickerService.findAll(filter, pageable));
		return "admin-sticker";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("sticker", stickerService.findForm(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		commodityService.setNullSticker(id);
		stickerService.delete(id);
		return "redirect:/admin/sticker" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter, SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/sticker" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("sticker") @Valid StickerForm sticker,
			BindingResult br, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter, SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter);
		stickerService.save(sticker);
		status.setComplete();
		return "redirect:/admin/sticker" + getParams(pageable, filter);
	}

}
