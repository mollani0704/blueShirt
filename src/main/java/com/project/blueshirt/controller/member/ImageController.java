package com.project.blueshirt.controller.member;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.service.estimate.EstimateService;
import com.project.blueshirt.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ImageController {
	
	@Value("${file.path}")
	private String filePath;

	@GetMapping("/image/review")
	public ResponseEntity<?> getMainReviewImage(@RequestParam("filename") String filename) {
		String folder = "review/";
		
		Resource resource = new FileSystemResource(filePath + folder + filename);
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try {
			filePath = Paths.get(filePath + folder + filename);
			header.add("Content-type", Files.probeContentType(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@GetMapping("/image/estimate")
	public ResponseEntity<?> getEstimateImage(@RequestParam("filename") String filename) {
		String folder = "estimate/";
		
		Resource resource = new FileSystemResource(filePath + folder + filename);
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try {
			filePath = Paths.get(filePath + folder + filename);
			header.add("Content-type", Files.probeContentType(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
}
