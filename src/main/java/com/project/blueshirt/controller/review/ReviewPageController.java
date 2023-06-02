package com.project.blueshirt.controller.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewPageController {

	@GetMapping("/review")
	public String reviewPage() {
		return "/page/review/review";
	}
	
	@GetMapping("/review/save")
	public String reivewSave() {
		return "/page/review/review_save";
	}
	
}
