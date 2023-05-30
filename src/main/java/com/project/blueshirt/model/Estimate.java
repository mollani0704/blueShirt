package com.project.blueshirt.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Estimate {
	private int code;
	private String title;
	private String category;
	private String content;
	private String password;
	private LocalDateTime create_date;
}
