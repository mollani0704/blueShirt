package com.project.blueshirt.model.estimate;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Estimate {
	private int code;
	private String name;
	private String phoneNumber;
	private String category;
	private String location;
	private String size;
	private String content;
	private LocalDateTime create_date;
}
