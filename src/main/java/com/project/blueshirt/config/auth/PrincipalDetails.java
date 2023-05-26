package com.project.blueshirt.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.blueshirt.dto.SignInDto;
import com.project.blueshirt.model.Member;

import lombok.Getter;

@Getter
public class PrincipalDetails implements UserDetails{

	private Member member;
	
	public PrincipalDetails(Member member) {
		this.member = member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collector = new ArrayList<GrantedAuthority>();
		
		collector.add(() -> {
			return "ROLE_" + member.getRole();
		});
		
		return collector;
	}

	@Override
	public String getPassword() {
		
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		
		return member.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
