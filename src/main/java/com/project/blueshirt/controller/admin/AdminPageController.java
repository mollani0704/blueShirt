package com.project.blueshirt.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.blueshirt.dto.EstimateDetailDto;
import com.project.blueshirt.model.estimate.Estimate;
import com.project.blueshirt.model.item.Item;
import com.project.blueshirt.model.review.Review;
import com.project.blueshirt.repository.review.ReviewRepository;
import com.project.blueshirt.service.estimate.EstimateService;
import com.project.blueshirt.service.item.ItemService;
import com.project.blueshirt.service.review.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminPageController {
	
	private final ItemService itemService;
	private final ReviewService reviewService;
	private final EstimateService estimateService;
	
	@GetMapping("/admin")
	public String adminPage() {
		return "/page/admin/admin";
	}
	
	@GetMapping("/admin/items")
	public String adminItemList(Model model) {
		
		try {
			List<Item> itemLists = itemService.getItems();
			model.addAttribute("itemLists", itemLists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "/page/admin/item/admin_item";
	}
	
	@GetMapping("/admin/items/save")
	public String adminItemSave() {
		return "/page/admin/item/admin_itemSave";
	}
	
	@GetMapping("/admin/item/{itemCode}")
	public String adminItemDetail(@PathVariable int itemCode, Model model) {
		
		try {
			Item data = itemService.getItem(itemCode);
			model.addAttribute("item", data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "/page/admin/item/admin_itemDetail";
	}
	
	@GetMapping("/admin/reviews")
	public String adminReviewList(Model model) {
		
		try {
			List<Review> reviewLists = reviewService.getReviews();
			model.addAttribute("reviewLists", reviewLists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "/page/admin/review/admin_reviews";
	}
	
	@GetMapping("/admin/reviews/{reviewCode}")
	public String adminReviewModifyPage(@PathVariable int reviewCode,
			Model model) {
		try {
			Review review = reviewService.getReview(reviewCode);
			model.addAttribute("review", review);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "오류 발생";
		}
		
		return "/page/admin/review/admin_reviewModify";
	}
	
	@GetMapping("/admin/review/save")
	public String adminReviewSave() {
		return "/page/admin/review/admin_reviewSave";
	}
	
	@GetMapping("/admin/estimates/lists")
	public String adminEstimatesList(Model model) {
		
		try {
			List<Estimate> estimateList = estimateService.getEstimates();
			model.addAttribute("estimateList", estimateList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("오류 발생");
			
		}
		
		return "/page/admin/estimate/admin_estimateList";
	}
	
	@GetMapping("/admin/estimates/{estimateCode}")
	public String adminEstimateDetail(@PathVariable int estimateCode, Model model) {
		
		try {
			EstimateDetailDto estimate = estimateService.getEstimate(estimateCode);
			model.addAttribute("estimate", estimate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "/page/admin/estimate/admin_estimateDetail";
		
	}
	
	
	
}
