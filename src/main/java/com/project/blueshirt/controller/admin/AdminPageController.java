package com.project.blueshirt.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/admin/review")
	public String adminReviewList(Model model) {
		
		try {
			List<Review> reviewLists = reviewService.getReviews();
			model.addAttribute("reviewLists", reviewLists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생");
		}
		
		return "/page/admin/review/admin_review";
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
	
}
