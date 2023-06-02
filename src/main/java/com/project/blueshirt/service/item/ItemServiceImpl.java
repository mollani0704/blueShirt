package com.project.blueshirt.service.item;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.blueshirt.dto.SaveItemDto;
import com.project.blueshirt.model.Estimate;
import com.project.blueshirt.model.EstimateImgFile;
import com.project.blueshirt.model.Item;
import com.project.blueshirt.model.ItemImgFile;
import com.project.blueshirt.repository.estimate.EstimateRepository;
import com.project.blueshirt.repository.item.ItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

	private final ItemRepository itemRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public boolean saveItem(SaveItemDto saveItemDto) throws Exception {
		
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		
		Item item = null;
		boolean result = false;
		
		item = Item.builder()
					.item_name(saveItemDto.getItem_name())
					.price(saveItemDto.getItem_price())
					.stockQuantity(saveItemDto.getItem_stockQuantity())
					.build();
		
		result = itemRepository.saveItem(item) > 0 ;
		
		if(predicate.test(saveItemDto.getItemImageFiles().get(0).getOriginalFilename())) {
			List<ItemImgFile> itemImgFiles = new ArrayList<ItemImgFile>();
			
			for(MultipartFile file : saveItemDto.getItemImageFiles()) {
				String originalFileName = file.getOriginalFilename();
				String tempFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
				
				log.info(tempFileName);
				
				Path uploadPath = Paths.get(filePath, "item/" + tempFileName);
				
				File f = new File(filePath + "item");
				
				if(!f.exists() ) {
					f.mkdirs();
				}
				
				try {					
					Files.write(uploadPath, file.getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				itemImgFiles.add(ItemImgFile.builder()
						.item_code(item.getCode())
						.file_name(tempFileName)
						.build());
				
			}
			
			itemRepository.saveItemImgFiles(itemImgFiles);
			
		}
		
		return result;
	}

}
