package ua.com.shop.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Butt;
import ua.com.shop.service.ButtService;

@RestController
@RequestMapping("/butt")
public class ButtRestController {

	@Autowired
	private ButtService service;

	@GetMapping(headers = { "Accept=application/json" })
	public List<Butt> get() {
		return service.findAll();
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@GetMapping(headers = { "Accept=application/json" }, params = { "page",
			"size" })
	public Page<Butt> get(@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		return service.findAll(filter, pageable);
	}

	@PostMapping
	public Butt post(@RequestBody Butt ingredient) {
		return service.save(ingredient);
	}

	@DeleteMapping(value = "/{id}", headers = { "Accept=application/json" })
	public HttpStatus delete(@PathVariable Long id) {
		service.delete(id);
		return HttpStatus.OK;
	}

	@PutMapping(value = "/{id}", headers = { "Accept=application/json" })
	public Butt put(@PathVariable Long id, @RequestBody Butt butt) {
		butt.setId(id);
		return service.save(butt);
	}

	// @GetMapping
	// public List<Butt> findAll() {
	// return service.findAll();
	// }

	// @GetMapping("/{id}")
	// public Butt findOne(@PathVariable Long id) {
	// return service.findOne(id);
	// }
	//
	// @PutMapping
	// public Butt save(@RequestBody Butt butt) {
	// return service.save(butt);
	// }
	//
	// @DeleteMapping("/{id}")
	// public HttpStatus delete(@PathVariable Long id) {
	// service.delete(id);
	// return HttpStatus.OK;
	// }
}
