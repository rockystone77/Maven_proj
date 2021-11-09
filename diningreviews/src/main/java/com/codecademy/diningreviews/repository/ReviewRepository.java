package com.codecademy.diningreviews.repository;

import com.codecademy.diningreviews.model.Review;
import com.codecademy.diningreviews.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findReviewsByRestaurantIdAndStatus(Long restaurantId, ReviewStatus reviewStatus);
    List<Review> findReviewsByStatus(ReviewStatus reviewStatus);
}
