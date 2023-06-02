package com.project.blueshirt.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemPageController {
	
	@GetMapping("/items")
	public String itemListPage() {
		return "/page/item/item";
	}
	
	@GetMapping("/items/save")
	public String itemSavePage() {
		return "/page/item/item_save";
	}
	
}
