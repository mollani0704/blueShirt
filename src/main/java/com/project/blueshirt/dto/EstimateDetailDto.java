package com.project.blueshirt.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.project.blueshirt.model.estimate.Estimate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EstimateDetailDto {
	private int code;
	private String name;
	private String phoneNumber;
	private String category;
	private String location;
	private String size;
	private String content;
	private LocalDateTime create_date;
	private int file_code;
	private List<String> file_name;
	
}
