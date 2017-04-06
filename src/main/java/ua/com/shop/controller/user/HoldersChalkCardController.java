package ua.com.shop.controller.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Reviews;
import ua.com.shop.entity.User;
import ua.com.shop.service.HoldersChalkService;
import ua.com.shop.service.ReviewsService;
import ua.com.shop.service.UserService;

@Controller
@RequestMapping("/user/holdersChalkCard/{chalkId}")
public class HoldersChalkCardController {
	@Autowired
	private ReviewsService reviewsService;

	@Autowired
	private HoldersChalkService chalkService;

	@Autowired
	private UserService userService;

	@PostMapping
	public String save(Model model, @CookieValue(value = "userId") Long userId,
			@PathVariable Long chalkId, @RequestParam String name,
			@RequestParam String review) {
		Date date = new Date();
		User user = userService.findById(userId);
		user.setName(name);
		Reviews reviews = new Reviews();
		reviews.setHoldersChalk(chalkService.findOne(chalkId));
		reviews.setDate(date);
		reviews.setUser(user);
		reviews.setReview(review);
		reviewsService.save(reviews);
		return "redirect:/holdersChalk/details/{chalkId}";
	}

	@GetMapping("/cancel")
	public String cancel(@PageableDefault Pageable pageable,
			@PathVariable Long chalkId, SessionStatus status) {
		status.setComplete();
		return "redirect:/holdersChalk/details/{chalkId}";
	}
}
