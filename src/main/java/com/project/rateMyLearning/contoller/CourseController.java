package com.project.rateMyLearning.contoller;

import com.project.rateMyLearning.dto.ReviewDto;
import com.project.rateMyLearning.model.Review;
import com.project.rateMyLearning.repository.ReviewRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class CourseController {

    private final ReviewRepository reviewRepository;

    public CourseController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/api/course/review/getReviews")
    public List<Review> getReviews(@RequestParam String courseTitle) {
        List<Review> reviews = reviewRepository.getReviewsByCourse(courseTitle);
        return reviews;
    }






}
