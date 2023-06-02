package com.project.blueshirt.service.review;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.SaveReviewDto;

@Service
public interface ReviewService {
	public Boolean addReview(SaveReviewDto saveReviewDto) throws Exception;
}
