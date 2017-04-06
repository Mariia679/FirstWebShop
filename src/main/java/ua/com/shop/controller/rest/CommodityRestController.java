//package ua.com.shop.controller.rest;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import ua.com.shop.dto.CommodityDto;
//import ua.com.shop.dto.filter.CommodityFilter;
//import ua.com.shop.entity.Commodity;
//import ua.com.shop.service.CommodityService;
//
//@RestController
//@RequestMapping(value = "/commodity")
//public class CommodityRestController {
//
//	@Autowired
//	private CommodityService service;
//
//	@ModelAttribute("filter")
//	public CommodityFilter getFilter() {
//		return new CommodityFilter();
//	}
//
//	@GetMapping(headers = { "Accept=application/json" }, params = { "page",
//			"size" })
//	public Page<CommodityDto> get(@PageableDefault Pageable pageable,
//			@ModelAttribute("filter") CommodityFilter filter) {
//		return service.findAll(pageable, filter);
//	}
//
//	@GetMapping(headers = { "Accept=application/json" })
//	public List<CommodityDto> get() {
//		return service.findAll();
//	}
//
//	@GetMapping("/{id}")
//	public Commodity findOne(@PathVariable Long id) {
//		return service.findOne(id);
//	}
//
//	@PutMapping
//	public HttpStatus save(@RequestBody Commodity commodity) {
//		service.save(commodity);
//		return HttpStatus.OK;
//	}
//
//	@DeleteMapping("/{id}")
//	public HttpStatus delete(@PathVariable Long id) {
//		service.delete(id);
//		return HttpStatus.OK;
//	}
//}
