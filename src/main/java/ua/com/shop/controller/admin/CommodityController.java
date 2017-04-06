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

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.editor.ButtEditor;
import ua.com.shop.editor.CarvingJointEditor;
import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.DamperEditor;
import ua.com.shop.editor.FerulaEditor;
import ua.com.shop.editor.GashTypeEditor;
import ua.com.shop.editor.MainMaterialEditor;
import ua.com.shop.editor.MaterialJointEditor;
import ua.com.shop.editor.RingBumperEditor;
import ua.com.shop.editor.RingEndEditor;
import ua.com.shop.editor.ShaftEditor;
import ua.com.shop.editor.StickerEditor;
import ua.com.shop.editor.TypeStickerEditor;
import ua.com.shop.editor.WoodEditor;
import ua.com.shop.entity.Butt;
import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Damper;
import ua.com.shop.entity.Ferula;
import ua.com.shop.entity.GashType;
import ua.com.shop.entity.MainMaterial;
import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.entity.RingBumper;
import ua.com.shop.entity.RingEnd;
import ua.com.shop.entity.Shaft;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.TypeSticker;
import ua.com.shop.entity.User;
import ua.com.shop.entity.Wood;
import ua.com.shop.service.ButtService;
import ua.com.shop.service.CartItemService;
import ua.com.shop.service.CarvingJointService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.DamperService;
import ua.com.shop.service.FerulaService;
import ua.com.shop.service.GashTypeService;
import ua.com.shop.service.MainMaterialService;
import ua.com.shop.service.MaterialJointService;
import ua.com.shop.service.RingBumperService;
import ua.com.shop.service.RingEndService;
import ua.com.shop.service.ShaftService;
import ua.com.shop.service.StickerService;
import ua.com.shop.service.TypeStickerService;
import ua.com.shop.service.WoodService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.CommodityValidator;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private MainMaterialService mainMaterialService;

	@Autowired
	private WoodService woodService;

	@Autowired
	private ShaftService shaftService;

	@Autowired
	private ButtService buttService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FerulaService ferulaService;

	@Autowired
	private GashTypeService gashTypeService;

	@Autowired
	private StickerService stickerService;

	@Autowired
	private TypeStickerService typeStickerService;

	@Autowired
	private RingEndService ringEndService;

	@Autowired
	private RingBumperService ringBumperService;

	@Autowired
	private DamperService damperService;

	@Autowired
	private MaterialJointService materialJointService;

	@Autowired
	private CarvingJointService carvingJointService;

	@Autowired
	private CartItemService cartItemService;

	@InitBinder("commodity")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(MaterialJoint.class,
				new MaterialJointEditor(materialJointService));
		binder.registerCustomEditor(CarvingJoint.class, new CarvingJointEditor(
				carvingJointService));
		binder.registerCustomEditor(Shaft.class, new ShaftEditor(shaftService));
		binder.registerCustomEditor(Butt.class, new ButtEditor(buttService));
		binder.registerCustomEditor(Damper.class, new DamperEditor(
				damperService));
		binder.registerCustomEditor(RingBumper.class, new RingBumperEditor(
				ringBumperService));
		binder.registerCustomEditor(RingEnd.class, new RingEndEditor(
				ringEndService));
		binder.registerCustomEditor(TypeSticker.class, new TypeStickerEditor(
				typeStickerService));
		binder.registerCustomEditor(Sticker.class, new StickerEditor(
				stickerService));
		binder.registerCustomEditor(GashType.class, new GashTypeEditor(
				gashTypeService));
		binder.registerCustomEditor(Ferula.class, new FerulaEditor(
				ferulaService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(
				categoryService));
		binder.registerCustomEditor(Wood.class, new WoodEditor(woodService));
		binder.registerCustomEditor(MainMaterial.class, new MainMaterialEditor(
				mainMaterialService));
		binder.setValidator(new CommodityValidator(commodityService));
	}

	@ModelAttribute("commodity")
	public CommodityForm getForm() {
		return new CommodityForm();
	}

	@ModelAttribute("filter")
	public CommodityFilter getFilter() {
		return new CommodityFilter();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("page", commodityService.findAll(pageable, filter));
		model.addAttribute("mainMaterials", mainMaterialService.findAll());
		model.addAttribute("woods", woodService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("ferulas", ferulaService.findAll());
		model.addAttribute("gashTypes", gashTypeService.findAll());
		model.addAttribute("stickers", stickerService.findAll());
		model.addAttribute("typeStickers", typeStickerService.findAll());
		model.addAttribute("ringEnds", ringEndService.findAll());
		model.addAttribute("ringBumpers", ringBumperService.findAll());
		model.addAttribute("dampers", damperService.findAll());
		model.addAttribute("dampers", damperService.findAll());
		model.addAttribute("shafts", shaftService.findAll());
		model.addAttribute("butts", buttService.findAll());
		model.addAttribute("carvingJs", carvingJointService.findAll());
		model.addAttribute("materialJs", materialJointService.findAll());
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
		return "admin-commodity";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId) {
		model.addAttribute("commodity", commodityService.findForm(id));
		return show(model, pageable, filter, userId);
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter) {
		commodityService.delete(id);
		return "redirect:/admin/commodity" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter,
			SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/commodity" + getParams(pageable, filter);
	}

	@PostMapping
	public String save(
			@ModelAttribute("commodity") @Valid CommodityForm commodity,
			BindingResult br, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") CommodityFilter filter,
			@CookieValue(defaultValue = "0", name = "userId") Long userId,
			SessionStatus status) {
		if (br.hasErrors())
			return show(model, pageable, filter, userId);
		commodityService.save(commodity);
		status.setComplete();
		return "redirect:/admin/commodity" + getParams(pageable, filter);

	}

	private String getParams(Pageable pageable, CommodityFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMax().isEmpty()) {
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if (!filter.getMin().isEmpty()) {
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		if (!filter.getNameCommodity().isEmpty()) {
			buffer.append("&name=");
			buffer.append(filter.getNameCommodity());
		}
		if (!filter.getFerulaId().isEmpty()) {
			for (Long id : filter.getFerulaId()) {
				buffer.append("&ferulaId=");
				buffer.append(id);
			}
		}
		if (!filter.getWoodId().isEmpty()) {
			for (Long id : filter.getWoodId()) {
				buffer.append("&woodId=");
				buffer.append(id);
			}
		}
		if (!filter.getMainMaterialId().isEmpty()) {
			for (Long id : filter.getMainMaterialId()) {
				buffer.append("&mainMaterialId=");
				buffer.append(id);
			}
		}
		if (!filter.getCategoryId().isEmpty()) {
			for (Long id : filter.getCategoryId()) {
				buffer.append("&categoryId=");
				buffer.append(id);
			}
		}
		if (!filter.getWeightCue().isEmpty()) {
			buffer.append("&weight=");
			buffer.append(filter.getWeightCue());
		}
		if (!filter.getLengthCue().isEmpty()) {
			buffer.append("&length=");
			buffer.append(filter.getLengthCue());
		}
		if (!filter.getMaterialJointId().isEmpty()) {
			for (Long id : filter.getMaterialJointId()) {
				buffer.append("&materialJointId=");
				buffer.append(id);
			}
		}
		if (!filter.getCarvingJointId().isEmpty()) {
			for (Long id : filter.getCarvingJointId()) {
				buffer.append("&carvingJointId=");
				buffer.append(id);
			}
		}
		if (!filter.getDamperId().isEmpty()) {
			for (Long id : filter.getDamperId()) {
				buffer.append("&damperId=");
				buffer.append(id);
			}
		}
		if (!filter.getRingBumperId().isEmpty()) {
			for (Long id : filter.getRingBumperId()) {
				buffer.append("&ringBumperId=");
				buffer.append(id);
			}
		}
		if (!filter.getRingEndId().isEmpty()) {
			for (Long id : filter.getRingEndId()) {
				buffer.append("&ringEndId=");
				buffer.append(id);
			}
		}
		if (!filter.getTypeStickerId().isEmpty()) {
			for (Long id : filter.getTypeStickerId()) {
				buffer.append("&typeStickerId=");
				buffer.append(id);
			}
		}
		if (!filter.getStickerId().isEmpty()) {
			for (Long id : filter.getStickerId()) {
				buffer.append("&stickerId=");
				buffer.append(id);
			}
		}
		if (!filter.getButtId().isEmpty()) {
			for (Long id : filter.getButtId()) {
				buffer.append("&buttId=");
				buffer.append(id);
			}
		}
		if (!filter.getShaftId().isEmpty()) {
			for (Long id : filter.getShaftId()) {
				buffer.append("&shaftId=");
				buffer.append(id);
			}
		}
		if (!filter.getGashTypeId().isEmpty()) {
			for (Long id : filter.getGashTypeId()) {
				buffer.append("&gashTypeId=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
}
