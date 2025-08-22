package com.project.rateMyLearning.service;

import com.project.rateMyLearning.dto.ReviewDto;
import com.project.rateMyLearning.dto.ReviewerDto;
import com.project.rateMyLearning.exception.ResourceNotFoundException;
import com.project.rateMyLearning.model.Course;
import com.project.rateMyLearning.model.Instructor;
import com.project.rateMyLearning.model.Review;
import com.project.rateMyLearning.model.Reviewer;
import com.project.rateMyLearning.repository.ReviewRepository;
import com.project.rateMyLearning.repository.ReviewerRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CourseService courseService;
    private final ReviewerService reviewerService;
    private final ReviewerRepository reviewerRepository;

    public ReviewService(ReviewRepository reviewRepository, CourseService courseService, ReviewerService reviewerService, ReviewerRepository reviewerRepository) {
        this.reviewRepository = reviewRepository;
        this.courseService = courseService;
        this.reviewerService = reviewerService;
        this.reviewerRepository = reviewerRepository;
    }

    public int getTotalReviews(String name) {
        return reviewRepository.getTotalReviews(name);
    }

    public int getAvgRating(String name) {
        return reviewRepository.getAvgRating(name);
    }

    //Posts review but before posting the review it makes sure that the review is already present or not
    public ReviewDto postReview(ReviewDto reviewDto, String username){
        Reviewer reviewer = reviewerRepository.getByUsername(username);
        Review review = reviewDto.getReview();

        review.setReviewer(reviewer);
        Course course = reviewDto.getCourse();
        review.setCourse(course);
        String link = review.getCourse().getLink();
        Review review1 = reviewRepository.getReviewByLink(link, username);
        if(review1 != null){
            throw new RuntimeException("You have already given review for this course, you can give it only once!");
        }
        ReviewDto reviewDto1 = new ReviewDto();
        course = courseService.addCourse(course);
        review.setCourse(course);
        review = reviewRepository.save(review);

        reviewDto1.setReview(review);
        reviewDto1.setCourse(course);

        return reviewDto1;
    }

    public void deleteReview(int reviewId){
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new ResourceNotFoundException("Review Not Found"));
        reviewRepository.delete(review);
    }

    public List<Review> getReviews(String name) {
        if(name == null){
            throw new RuntimeException("Review Name is Null");
        }
        List<Review> reviews = reviewerRepository.getReviewsByUsername(name);
        return reviews;
    }

//    public ReviewDto updateReview(Review review){
//        if(review.getReviewer())
//        {
//
//        }
//    }
}
