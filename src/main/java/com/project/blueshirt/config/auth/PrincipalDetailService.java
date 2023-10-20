package com.project.blueshirt.config.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.blueshirt.model.Member;
import com.project.blueshirt.repository.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member memberEntity = null;
		
		try {
			memberEntity = memberRepository.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username);
		} 
		
		if(memberEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new PrincipalDetails(memberEntity);
	}

}
