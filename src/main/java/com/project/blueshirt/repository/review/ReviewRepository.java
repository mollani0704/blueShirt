package com.project.blueshirt.repository.review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.model.review.ReviewImgFile;

@Repository
@Mapper
public interface ReviewRepository {
	
	public int saveReview(Review review);
	public int saveReviewImgFiles(List<ReviewImgFile> reviewImgFiles);
	
	public List<Review> getReviewList();
	public Review getReview(int reviewCode);
	
	public int modifyReview(Map<String, Object> map);
	
	public int deleteReview(int reviewCode);
}
