package com.project.blueshirt.controller.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.SaveItemDto;
import com.project.blueshirt.service.item.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService itemService;
	
	@PostMapping("/api/item/save")
	public ResponseEntity<?> saveItem(SaveItemDto saveItemDto) {
		
		Boolean status = false;
		
		try {
			status = itemService.saveItem(saveItemDto);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity.internalServerError().body(status);
		}
		
		return ResponseEntity.ok().body(status);
	}
	
	
}
