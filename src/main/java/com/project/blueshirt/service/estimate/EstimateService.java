package com.project.blueshirt.service.estimate;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SaveEsitmateDto;

@Service
public interface EstimateService {
	public Boolean addEstimate(SaveEsitmateDto saveEsitmateDto) throws Exception;
}
