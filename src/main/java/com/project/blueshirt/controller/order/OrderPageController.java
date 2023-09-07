package com.project.blueshirt.controller.order;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.blueshirt.model.item.Item;
import com.project.blueshirt.model.order.Order;
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
			model.addAttribute("order", new Order());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "page/order/order";
	}
	
	@PostMapping("/order")
	public String orderSave(@Validated Order order, BindingResult bindingResult,
							@RequestParam int itemCode,
							RedirectAttributes redirectAttributes, 
							Model model) {
		
		order.setItemCode(itemCode);
		
		if(bindingResult.hasErrors()) {
			log.info("error = {}", bindingResult);
			try {
				Item data = itemService.getItem(itemCode);
				model.addAttribute("itemData", data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "page/order/order";
		}
		
		return "redirect:/order/pay";
	}
}
