package com.project.rateMyLearning.service;

import com.project.rateMyLearning.dto.SearchCourseDto;
import com.project.rateMyLearning.model.Course;
import com.project.rateMyLearning.model.CourseReview;
import com.project.rateMyLearning.model.Review;
import com.project.rateMyLearning.repository.CourseReviewRepository;
import com.project.rateMyLearning.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseReviewService {

    private final CourseReviewRepository courseReviewRepository;
    private final ReviewRepository reviewRepository;

    public CourseReviewService(CourseReviewRepository courseReviewRepository, ReviewRepository reviewRepository) {
        this.courseReviewRepository = courseReviewRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<SearchCourseDto> searchCourse(String courseName) {
        List<Course> courses = courseReviewRepository.searchCourses(courseName);
        List<SearchCourseDto> searchCourseDtos = new ArrayList<>();
        for (Course course : courses) {
            SearchCourseDto searchCourseDto = new SearchCourseDto();
            int totalReviews = reviewRepository.getTotalReviewsForCourse(course.getId());
            searchCourseDto.setTotalReviews(totalReviews);
            int avgRating = reviewRepository.getAvgRatingForCourse(course.getId());
            searchCourseDto.setAvgRating(avgRating);
            searchCourseDto.setCourse(course);
            List<Review> reviews = reviewRepository.getReviewsForCourse(course.getId());
            searchCourseDto.setReviews(reviews);
            searchCourseDtos.add(searchCourseDto);
        }

        return searchCourseDtos;
    }



}
