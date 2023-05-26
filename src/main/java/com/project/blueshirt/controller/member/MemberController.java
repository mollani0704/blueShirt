package com.project.blueshirt.controller.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;
import com.project.blueshirt.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping("/auth/signup")
	public ResponseEntity<?> signup(@RequestBody Member member) {
		
		boolean status = false;
		
		try {
			status = memberService.signUpMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(status);
		}
		
		return ResponseEntity.ok().body(status);	
	}
	
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
