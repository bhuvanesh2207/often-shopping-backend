package com.oftenshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.entity.Review;
import com.oftenshopping.service.ReviewService;

@CrossOrigin("*")
@RestController
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@GetMapping("/listOfReview")
	public List<Review> listOfReview (@RequestParam Long productId){
		return service.listOfReview(productId);
	}
	
	@GetMapping("/avgReview")
	public String avgReview(@RequestParam Long productId) {
		return service.avgReview(productId);
	}
}
