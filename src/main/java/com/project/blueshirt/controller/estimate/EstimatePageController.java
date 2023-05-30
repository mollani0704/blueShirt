package com.project.blueshirt.controller.estimate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstimatePageController {
	
	@GetMapping("/estimates")
	public String estimates() {
		return "/page/estimate/estimates";
	}
	
	@GetMapping("/estimates/save")
	public String estimatesSave() {
		return "/page/estimate/estimates_save";
	}
	
}
