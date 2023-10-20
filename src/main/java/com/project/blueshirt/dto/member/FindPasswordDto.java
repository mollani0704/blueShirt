package com.project.blueshirt.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindPasswordDto {
	private String userNameData;
	private String userIdData;
	private String emailData;
}
