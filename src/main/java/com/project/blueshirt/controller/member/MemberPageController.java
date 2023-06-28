package com.project.blueshirt.controller.member;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberPageController {
	
	private final ReviewService reviewService;

	@GetMapping("/")
	public String indexPage(Model model) {
		
		try {
			
			List<Review> reviews = reviewService.getReviews();
	
			model.addAttribute("reviews", reviews);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "오류 발생";
		}
		
		return "page/main";
	}
	
	@GetMapping("/chungCompany")
	public String introducePage() {
		return "page/company";
	}
	
	@GetMapping("/signup")
	public String signUpPage() {
		return "page/member/signup";
	}
	
	@GetMapping("/signin") 
	public String SignInPage() {
		return "page/member/signin";
	}
	
}
