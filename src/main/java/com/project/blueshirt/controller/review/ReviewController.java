package com.project.blueshirt.controller.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.dto.ModifyReviewDto;
import com.project.blueshirt.dto.SaveReviewDto;
import com.project.blueshirt.service.review.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService reviewService;
	
	@PostMapping("/api/review/save")
	public ResponseEntity<?> saveReview(SaveReviewDto saveReviewDto) {
		
		Boolean result = false;
		
		try {
			result = reviewService.addReview(saveReviewDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(result);
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping("/api/review/modify/{reviewCode}")
	public ResponseEntity<?> modifyReview(@PathVariable int reviewCode, ModifyReviewDto modifyReviewDto) {
		
		Boolean result = false;
		
		try {
			result = reviewService.modifyReview(reviewCode,modifyReviewDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(result);
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/api/review/delete/{reviewCode}")
	public ResponseEntity<?> deleteReview(@PathVariable int reviewCode) {
		Boolean result = false;
		
		try {
			result = reviewService.deleteReview(reviewCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(result);
		}
		
		return ResponseEntity.ok().body(result);
	}

	
}
