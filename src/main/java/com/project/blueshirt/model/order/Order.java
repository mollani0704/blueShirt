package com.project.blueshirt.model.order;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

@Data
public class Order {
	
	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Pattern(regexp="\\d{2,3}-\\d{3,4}-\\d{4}$", message="핸드폰 번호의 약식과 맞지 않습니다.")
	private String phoneNumber;
	@NotBlank
	private String postCode;
	@NotBlank
	private String roadAddress;
	@NotBlank
	private String detailAddress;
	private String jibunAddress;
	private String extraAddress;
	private int itemCode;
	private int stockQuantity;
	private int totalPriceResult;
	
	public Order() {
		
	}
	
	
}
