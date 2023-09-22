package com.project.blueshirt.controller.member;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.service.member.MemberService;
import com.project.blueshirt.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberPageController {
	
	@Value("${file.path}")
	private String filePath;
	
	private final MemberService memberService;
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
	
	@GetMapping("/signin/findId")
	public String findPage() {
		return "page/member/findId";
	}
	
	@PostMapping("/signin/findId")
	public String findId(String username, Model model) {
		String findId = null;
		try {
			findId = memberService.findId(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("findId = {}", findId);
		model.addAttribute("findId", findId);
		
		return "redirect:/signin/findId";
	}
	
}
