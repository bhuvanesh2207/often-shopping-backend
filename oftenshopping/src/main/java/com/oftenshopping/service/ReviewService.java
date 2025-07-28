package com.oftenshopping.service;

import java.util.List;

import com.oftenshopping.entity.Review;

public interface ReviewService {

	List<Review> listOfReview(Long productId);

	String avgReview(Long productId);

}
