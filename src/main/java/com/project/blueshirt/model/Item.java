package com.project.blueshirt.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Item {
	private int code;
	private String item_name;
	private int price;
	private int stockQuantity;
}
