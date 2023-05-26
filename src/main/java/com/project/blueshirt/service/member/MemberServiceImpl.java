package com.project.blueshirt.service.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;
import com.project.blueshirt.model.Role;
import com.project.blueshirt.repository.member.MemberRepository;

import lombok.RequiredArgsConstructor;

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
	public Boolean signInMember(Member member) throws Exception {
		
		Boolean result = false;
		Member memberEntity = memberRepository.readMember(member);
		
		if(memberEntity == null) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}

}
