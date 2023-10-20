package com.project.blueshirt.service.member;



import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.dto.member.FindPasswordDto;
import com.project.blueshirt.model.Member;
import com.project.blueshirt.model.Role;
import com.project.blueshirt.repository.member.MemberRepository;
import com.project.blueshirt.service.mail.MailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder encoder;

	
	@Override
	public Boolean signUpMember(Member member) throws Exception {
		
		String originPassword = member.getPassword();
		String encodePassword = encoder.encode(originPassword);
		
		member.setPassword(encodePassword);
		member.setRole("ROLE_USER");
		
		return memberRepository.saveMember(member) > 0;
	}

	@Override
	public Boolean findMember(String userId) throws Exception {
		
		Boolean result = false;
		Member memberEntity = memberRepository.findByUsername(userId);
		
		if(memberEntity == null) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}

	@Override
	public String findId(String username) throws Exception {
		
		String userId = memberRepository.findId(username);
		
		if(userId == null) {
			return null;
		} else {
			return userId;
		}
	}

	@Override
	public String findPassword(FindPasswordDto findPasswordDto) throws Exception {
		
		String userPassword = memberRepository.findPassword(findPasswordDto);
		log.info("userPassword = {}", userPassword);
		
		return null;
	}
}
