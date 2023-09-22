package com.project.blueshirt.service.member;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;

public interface MemberService{
	
	public Boolean signUpMember(Member member) throws Exception;
	public Boolean findMember(String userId) throws Exception;
	public String findId(String username) throws Exception;

}
