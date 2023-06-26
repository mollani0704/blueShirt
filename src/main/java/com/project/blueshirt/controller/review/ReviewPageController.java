package com.project.blueshirt.controller.review;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.service.review.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewPageController {
	
	private final ReviewService reviewService;

	@GetMapping("/review")
	public String reviewPage(Model model) {
		
		try {
			List<Review> reviews = reviewService.getReviews();
			model.addAttribute("reviews", reviews);
		} catch (Exception e) {
			e.printStackTrace();
			return "오류 발생";
		}
		
		return "/page/review/review";
	}
	
	@GetMapping("/review/{reviewCode}")
	public String reviewDetailPage(@PathVariable int reviewCode, Model model) {
		
		try {
			Review review = reviewService.getReview(reviewCode);
			model.addAttribute("review", review);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "오류 발생";
		}
		
		return "/page/review/reviewDetail";
	}
	
	
}
