package com.project.blueshirt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemImgFile {
	private int file_code;
	private int item_code;
	private String file_name;
}
