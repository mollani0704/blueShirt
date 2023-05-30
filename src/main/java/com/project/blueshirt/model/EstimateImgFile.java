package com.project.blueshirt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EstimateImgFile {
	private int file_code;
	private int estimate_code;
	private String file_name;

}
