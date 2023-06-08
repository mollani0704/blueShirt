package com.project.blueshirt.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberPageController {

	@GetMapping("/")
	public String indexPage() {
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
