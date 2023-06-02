package com.project.blueshirt.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveReviewDto {
	private String title;
	private List<MultipartFile> reviewImageFiles;
	private String content;
}
