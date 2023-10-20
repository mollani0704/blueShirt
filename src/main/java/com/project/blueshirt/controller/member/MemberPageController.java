package com.project.blueshirt.controller.member;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String indexPage(Model model, Authentication auth, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		try {
			List<Review> reviews = reviewService.getReviews();
			model.addAttribute("reviews", reviews);
			
			if(auth != null) {
				log.info("username = {}", auth.getName());
				model.addAttribute("username", auth.getName());
				session.setAttribute("loginMemberName", auth.getName());
			} else {
				log.info("auth 데이터가 null 입니다.");
			}
			
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
	public String SignInPage(@RequestParam(value = "error", required = false) String error,
							@RequestParam(value = "exception", required = false) String exception,
							Model model) {
		
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		
		return "page/member/signin";
	}
	
	@GetMapping("/signin/findId")
	public String findPage() {
		return "page/member/findId";
	}
	
	@GetMapping("/signin/findPassword")
	public String findPassword() {
		return "page/member/findPassword";
	}
	
//	@PostMapping("/signin/findId")
//	public String findId(String username, RedirectAttributes redirectAttributes) {
//		String findId = null;
//		try {
//			findId = memberService.findId(username);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		log.info("findId = {}", findId);
//		redirectAttributes.addAttribute("findId", findId);
//		
//		return "redirect:/signin/findId";
//	}
	
}
