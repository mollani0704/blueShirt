package com.project.blueshirt.repository.estimate;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.blueshirt.model.estimate.Estimate;
import com.project.blueshirt.model.estimate.EstimateDetail;
import com.project.blueshirt.model.estimate.EstimateImgFile;

@Repository
@Mapper
public interface EstimateRepository {
	
	public int saveEstimate(Estimate estimate);
	public int saveEstimateImgFiles(List<EstimateImgFile> estimateImgFiles);
	
	public List<Estimate> getEstimateList();
	public List<EstimateDetail> getEstimate(int estimateCode);
}
