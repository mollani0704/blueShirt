package com.project.blueshirt.controller.order;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.model.order.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OrderController {
	
	// 지금 order에 대한 문제점
	// 내가 validation에 대한 것을 이제 Spring과 thymeleaf를 이용해서 화면에 출력할려고 한다
	// 하지만 이렇게 내가 배운 validation을 이용하려면 Controller를 이용해야 한다. 
	// 그래서 RestController에서 값을 옮겨야 겠지.
	
	@PostMapping("/api/order")
	public ResponseEntity<?> saveOrder(@RequestBody Order order, 
			@RequestParam("itemCode") int itemCode) {
		
		Map<String, String> errors = new HashMap<String, String>();
		
		log.info("itemCode = {}", itemCode);
		log.info("order = {}", order);
		
		if(!StringUtils.hasText(order.getName())) {
			errors.put("userName", "이름은 필수입니다.");
		}
//		
//		if(!StringUtils.hasText(order.getEmail())) {
//			bindingResult.addError(new FieldError("order", "email", "이메일은 필수입니다."));
//		}
//		
//		if(!StringUtils.hasText(order.getPhoneNumber())) {
//			bindingResult.addError(new FieldError("order", "email", "휴대폰 번호는 필수입니다."));
//		}
//		
//		if(!StringUtils.hasText(order.getPostCode())) {
//			bindingResult.addError(new FieldError("order", "email", "우편번호는 필수입니다."));
//		}
//		
//		if(!StringUtils.hasText(order.getRoadAddress())) {
//			bindingResult.addError(new FieldError("order", "email", "도로명 주소는 필수입니다."));
//		}
//		
//		if(!StringUtils.hasText(order.getDetailAddress())) {
//			bindingResult.addError(new FieldError("order", "email", "상세 주소는 필수입니다."));
//		}
		
		if(!errors.isEmpty()) {
			return ResponseEntity.ok().body(errors);
		}
		
		return ResponseEntity.ok().body("에러없음");
		
}
	
}
