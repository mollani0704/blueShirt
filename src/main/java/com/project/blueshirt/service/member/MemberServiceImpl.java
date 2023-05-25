package com.project.blueshirt.service.member;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;
import com.project.blueshirt.repository.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	
	@Override
	public Boolean signUpMember(Member member) throws Exception {
		
		return memberRepository.saveMember(member) > 0;
	}

	@Override
	public Boolean signInMember(SignInDto signInDto) throws Exception {
		
		Boolean result = false;
		Member member = memberRepository.readMember(signInDto);
		
		if(member == null) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}

}
