package com.project.blueshirt.repository.item;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.blueshirt.model.Item;
import com.project.blueshirt.model.ItemImgFile;

@Repository
@Mapper
public interface ItemRepository {
	public int saveItem(Item item);
	public int saveItemImgFiles(List<ItemImgFile> itemImgFile);
	
	public List<Item> getItemList();
}
