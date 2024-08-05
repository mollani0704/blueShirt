package com.project.blueshirt.controller.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.ModifyItemDto;
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
	
	@PutMapping("/api/item/modify/{itemCode}")
	public ResponseEntity<?> modifyItem(@PathVariable int itemCode, ModifyItemDto modifyItemDto) {
		Boolean result = false;
		try {
			result = itemService.modifyItem(itemCode, modifyItemDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(result);
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/api/item/delete/{itemCode}")
	public ResponseEntity<?> deleteItem(@PathVariable int itemCode) {
		Boolean result = false;
		try {
			result = itemService.deleteItem(itemCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(result);
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/api/item/test")
	public ResponseEntity<?> gitTestCode() {
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/api/item/test3")
	public ResponseEntity<?> gitTestCode3() {
		return ResponseEntity.ok(null);
	}
	
	
	
	
	
}
