package com.project.blueshirt.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.blueshirt.model.item.Item;
import com.project.blueshirt.service.item.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderPageController {
	
	private final ItemService itemService;
	
	@GetMapping("/order")
	public String orderPage(@RequestParam int itemCode, Model model) {
		
		Item data = null;
		try {
			data = itemService.getItem(itemCode);
			model.addAttribute("itemData", data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "page/order/order";
	}
}
