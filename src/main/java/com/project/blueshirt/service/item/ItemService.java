package com.project.blueshirt.service.item;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SaveItemDto;

@Service
public interface ItemService {
	public boolean saveItem(SaveItemDto saveItemDto) throws Exception;
}
