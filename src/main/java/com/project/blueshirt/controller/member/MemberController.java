package com.project.blueshirt.controller.member;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.dto.member.FindPasswordDto;
import com.project.blueshirt.dto.member.SignInReqDto;
import com.project.blueshirt.model.Member;
import com.project.blueshirt.service.mail.MailService;
import com.project.blueshirt.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
	
	@Value("${spring.mail.host}")
	private String host;
	@Value("#{new Integer('${spring.mail.port}')}")
	private int port;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("#{new Boolean('${spring.mail.properties.mail.smtp.auth}')}")
	private boolean auth;
	
	
	private final MemberService memberService;
	private final MailService mailService;
	
	/*
	 * 아이디 중복확인
	 */
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
	
	/*
	 * 회원가입
	 */
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
	
	/*
	 * 로그인
	 */
	@PostMapping("/auth/loginProc")
	public ResponseEntity<?> signIn(@Valid SignInReqDto dto) {
		
		log.info("username = {}", dto.getUsername());
		log.info("password = {}", dto.getPassword());
		
		return null;
	}
		
	/*
	 * 로그인 페이지에서 아이디 찾기 기능
	 */
	@PostMapping("/auth/findId")
	public ResponseEntity<?> findId(@RequestBody(required = false) String userNameData) {
		
		log.info("username = {}", userNameData);
		String findId;
		
		try {
			findId = memberService.findId(userNameData);
			log.info("findId = {}", findId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(null);
		}
		
		return ResponseEntity.ok().body(findId);
	}
	
	
	/*
	 * 로그인 페이지에서 비밀번호 찾기 기능
	 * 이메일을 이용한 인증번호.
	 */
	@PostMapping("/auth/findPassword")
	public ResponseEntity<?> findPassword(@RequestBody FindPasswordDto findPasswordDto) {
		log.info("findPassword_userIdData = {}", findPasswordDto.getUserIdData());
		log.info("findPassword_userNameData = {}", findPasswordDto.getUserNameData());
		log.info("findPassword_EmailData = {}", findPasswordDto.getEmailData());
		
		log.info("host = {}", host);
		log.info("port = {}", port);
		log.info("username = {}", username);
		log.info("password = {}", password);
		log.info("auth = {}", auth);
		
		String findPassword;
		
		try {
			findPassword = memberService.findPassword(findPasswordDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mailService.joinEmail(findPasswordDto.getEmailData());
		
		return null;
	}
	

//	@PostMapping("/auth/signin")
//	public ResponseEntity<?> signin(@RequestBody Member member) {		
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
