package com.project.blueshirt.service.item;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SaveItemDto;
import com.project.blueshirt.model.item.Item;

import java.util.List;

@Service
public interface ItemService {
	public boolean saveItem(SaveItemDto saveItemDto) throws Exception;
	public List<Item> getItems() throws Exception;
}
