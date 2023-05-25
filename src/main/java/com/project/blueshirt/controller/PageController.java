package com.project.blueshirt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String indexPage() {
		return "page/main";
	}
	
	@GetMapping("/signup")
	public String signUpPage() {
		return "page/member/signup";
	}
	
}
