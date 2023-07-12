package com.project.blueshirt.service.estimate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.EstimateDetailDto;
import com.project.blueshirt.dto.SaveEsitmateDto;
import com.project.blueshirt.model.estimate.Estimate;

@Service
public interface EstimateService {
	public Boolean addEstimate(SaveEsitmateDto saveEsitmateDto) throws Exception;
	
	public EstimateDetailDto getEstimate(int estimateCode) throws Exception;
	public List<Estimate> getEstimates() throws Exception;
}
