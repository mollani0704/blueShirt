package com.project.blueshirt.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
	private int code;
	private String category;
	private String title;
	private String content;
	private LocalDateTime create_date;
}
