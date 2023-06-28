package com.project.blueshirt.model.review;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
	private int file_code;
	private String file_name;
}
