package com.project.blueshirt.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyItemDto {
	private String item_name;
	private List<MultipartFile> itemImageFiles;
	private int price;
	private int stockQuantity;
}
