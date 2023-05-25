package com.project.blueshirt.repository.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;

@Repository
@Mapper
public interface MemberRepository {
	public int saveMember(Member member) throws Exception; 
	public Member readMember(SignInDto signInDto) throws Exception;
}
