package com.project.blueshirt.service.estimate;

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

import com.project.blueshirt.dto.SaveEsitmateDto;
import com.project.blueshirt.model.estimate.Estimate;
import com.project.blueshirt.model.estimate.EstimateImgFile;
import com.project.blueshirt.repository.estimate.EstimateRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstimateServiceImpl implements EstimateService{

	private final EstimateRepository estimateRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public Boolean addEstimate(SaveEsitmateDto saveEsitmateDto) throws Exception {
		
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		
		Estimate estimate = null;
		boolean result = false;
		
		estimate = Estimate.builder()
					.title(saveEsitmateDto.getTitle())
					.category(null)
					.content(saveEsitmateDto.getContent())
					.password(saveEsitmateDto.getPassword())
					.build();
		
		result = estimateRepository.saveEstimate(estimate) > 0;
		
		
		if(predicate.test(saveEsitmateDto.getImageFiles().get(0).getOriginalFilename())) {
			List<EstimateImgFile> estimateImgFiles = new ArrayList<EstimateImgFile>();
			
			for(MultipartFile file : saveEsitmateDto.getImageFiles()) {
				String originalFileName = file.getOriginalFilename();
				String tempFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
				
				log.info(tempFileName);
				
				Path uploadPath = Paths.get(filePath, "estimate/" + tempFileName);
				
				File f = new File(filePath + "estimate");
				
				if(!f.exists() ) {
					f.mkdirs();
				}
				
				try {					
					Files.write(uploadPath, file.getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				estimateImgFiles.add(EstimateImgFile.builder()
						.estimate_code(estimate.getCode())
						.file_name(tempFileName)
						.build());
				
			}
			
			estimateRepository.saveEstimateImgFiles(estimateImgFiles);
			
		}
		
		return result;
	}

}
