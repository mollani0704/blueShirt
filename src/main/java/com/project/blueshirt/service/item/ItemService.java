package com.project.blueshirt.service.item;

import com.project.blueshirt.model.Item;
import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SaveItemDto;

import java.util.List;

@Service
public interface ItemService {
	public boolean saveItem(SaveItemDto saveItemDto) throws Exception;
	public List<Item> getItems() throws Exception;
}
