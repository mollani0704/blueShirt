package com.project.blueshirt.controller.item;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.blueshirt.model.item.Item;
import com.project.blueshirt.service.item.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemPageController {
	
	private final ItemService itemService;
	
	@GetMapping("/items")
	public String itemListPage(Model model) {
		
		try {
			List<Item> itemLists = itemService.getItems();
			model.addAttribute("itemLists", itemLists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "/page/item/item";
	}
	
}
