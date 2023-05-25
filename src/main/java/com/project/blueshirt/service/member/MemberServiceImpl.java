package com.project.blueshirt.service.member;

import org.springframework.stereotype.Service;

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

}
