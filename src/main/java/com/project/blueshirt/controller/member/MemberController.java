package com.project.blueshirt.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;
import com.project.blueshirt.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping("/auth/duplication")
	public ResponseEntity<?> duplicateId(@RequestBody String userId) {
		
		boolean status = false;
		
		try {
			status = memberService.findMember(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("서버 오류");
		}
		
		return ResponseEntity.ok().body(status);
	}
	
	@PostMapping("/auth/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody Member member , BindingResult bindingResult) {
		
		boolean status = false;
		
		if(bindingResult.hasErrors()) {
			// validation 체크
			Map<String, String> errorMessage = new HashMap<String, String>();
			
			bindingResult.getFieldErrors().forEach(error -> {
				errorMessage.put(error.getField(), error.getDefaultMessage());
			});
			
			return ResponseEntity.badRequest().body(errorMessage);
		}
		
		try {
			status = memberService.signUpMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(status);
		}
		
		return ResponseEntity.ok().body(status);	
	}
	
//	
//	@PostMapping("/auth/findId")
//	public ResponseEntity<?> findId(String username) {
//		
//		String findId;
//		
//		try {
//			findId = memberService.findId(username);
//			log.info("findId = {}", findId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(null);
//		}
//		
//		return ResponseEntity.ok().body(findId);
//	}
	
//	@PostMapping("/auth/signin")
//	public ResponseEntity<?> signin(@RequestBody Member member) {
//		
//		boolean status = false;
//		try {
//			status = memberService.signInMember(member);
//			System.out.println(member.getUserId());
//			System.out.println(member.getPassword());
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(status);
//		}
//		
//		return ResponseEntity.ok().body(status);
//	}
	
}
