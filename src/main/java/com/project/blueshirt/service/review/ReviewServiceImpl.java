package com.project.blueshirt.service.review;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.blueshirt.dto.ModifyReviewDto;
import com.project.blueshirt.dto.SaveReviewDto;
import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.model.review.ReviewImgFile;
import com.project.blueshirt.repository.review.ReviewRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
	
	private final ReviewRepository reviewRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public Boolean addReview(SaveReviewDto saveReviewDto) throws Exception {
		
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		
		Review review = null;
		boolean result = false;
		
		review = Review.builder()
					.title(saveReviewDto.getTitle())
					.category(null)
					.content(saveReviewDto.getContent())
					.build();
		
		result = reviewRepository.saveReview(review) > 0;
		
		
		if(predicate.test(saveReviewDto.getReviewImageFiles().get(0).getOriginalFilename())) {
			List<ReviewImgFile> reviewImgFiles = new ArrayList<ReviewImgFile>();
			
			for(MultipartFile file : saveReviewDto.getReviewImageFiles()) {
				String originalFileName = file.getOriginalFilename();
				String tempFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
				
				log.info(tempFileName);
				
				Path uploadPath = Paths.get(filePath, "review/" + tempFileName);
				
				File f = new File(filePath + "review");
				
				if(!f.exists() ) {
					f.mkdirs();
				}
				
				try {					
					Files.write(uploadPath, file.getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				reviewImgFiles.add(ReviewImgFile.builder()
						.review_code(review.getCode())
						.file_name(tempFileName)
						.build());
				
			}
			
			reviewRepository.saveReviewImgFiles(reviewImgFiles);
			
		}
		
		return result;
	}

	@Override
	public List<Review> getReviews() throws Exception {
		
		List<Review> reviews = new ArrayList<>();
		
		reviewRepository.getReviewList().forEach(review -> {
			reviews.add(review);
		});
		
		return reviews;
	}

	@Override
	public Review getReview(int reviewCode) throws Exception {
		
		return reviewRepository.getReview(reviewCode);
	}

	@Override
	public Boolean modifyReview(int reviewCode, ModifyReviewDto modifyReviewDto) throws Exception {
		
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		
		Review review = null;
		boolean result = false;
		
		Map<String , Object> reviewParam = new HashMap<String, Object>();
		
		
		review = Review.builder()
					.title(modifyReviewDto.getTitle())
					.content(modifyReviewDto.getContent())
					.build();
		
		reviewParam.put("modifyReview", review);
		reviewParam.put("reviewCode", reviewCode);
		
		result = reviewRepository.modifyReview(reviewParam) > 0;
		
		
		if(predicate.test(modifyReviewDto.getReviewImageFiles().get(0).getOriginalFilename())) {
			List<ReviewImgFile> reviewImgFiles = new ArrayList<ReviewImgFile>();
			
			for(MultipartFile file : modifyReviewDto.getReviewImageFiles()) {
				String originalFileName = file.getOriginalFilename();
				String tempFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
				
				log.info(tempFileName);
				
				Path uploadPath = Paths.get(filePath, "review/" + tempFileName);
				
				File f = new File(filePath + "review");
				
				if(!f.exists() ) {
					f.mkdirs();
				}
				
				try {					
					Files.write(uploadPath, file.getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				reviewImgFiles.add(ReviewImgFile.builder()
						.review_code(review.getCode())
						.file_name(tempFileName)
						.build());
				
			}
			
			reviewRepository.saveReviewImgFiles(reviewImgFiles);
			
		}
		
		return result;
	}

	@Override
	public Boolean deleteReview(int reviewCode) throws Exception {
		
		return reviewRepository.deleteReview(reviewCode) > 0;
	}

}
