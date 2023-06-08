package com.project.blueshirt.service.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SaveReviewDto;
import com.project.blueshirt.model.review.Review;

@Service
public interface ReviewService {
	public Boolean addReview(SaveReviewDto saveReviewDto) throws Exception;
	public List<Review> getReviews() throws Exception;
}
