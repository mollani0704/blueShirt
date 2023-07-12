package com.project.blueshirt.model.estimate;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EstimateDetail {
	private int code;
	private String name;
	private String phoneNumber;
	private String category;
	private String location;
	private String size;
	private String content;
	private LocalDateTime create_date;
	private int file_code;
	private String file_name;
}
