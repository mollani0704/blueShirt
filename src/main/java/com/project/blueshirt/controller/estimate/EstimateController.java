package com.project.blueshirt.controller.estimate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.SaveEsitmateDto;
import com.project.blueshirt.service.estimate.EstimateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EstimateController {

	private final EstimateService estimateService;
	
	@PostMapping("/api/estimates/save")
	public ResponseEntity<?> estimateSave(SaveEsitmateDto saveEsitmateDto) {
		
		Boolean result = false;
		
		try {
			result = estimateService.addEstimate(saveEsitmateDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(result);
		}
		
		return ResponseEntity.ok().body(result);
	}
	
}
