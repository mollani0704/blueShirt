package com.project.blueshirt.model.review;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
	private int code;
	private String title;
	private String category;
	private String content;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
