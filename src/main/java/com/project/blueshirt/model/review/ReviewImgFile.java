package com.project.blueshirt.model.review;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewImgFile {
	private int file_code;
	private int review_code;
	private String file_name;
}
