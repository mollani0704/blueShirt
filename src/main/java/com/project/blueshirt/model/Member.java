package com.project.blueshirt.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	@NotBlank
	private String username;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-~!@#$%^&*_+=])[a-zA-Z\\d-~!@#$%^&*_+=]{8,16}$", 
			message = "비밀번호 최소 8글자 이상, 특수문자 넣어서 써주세요")
	private String password;
	private String address;
	private String role;
}
