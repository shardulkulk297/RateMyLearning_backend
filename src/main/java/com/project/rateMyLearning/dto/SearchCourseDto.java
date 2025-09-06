package com.project.rateMyLearning.dto;

import com.project.rateMyLearning.model.Course;
import com.project.rateMyLearning.model.CourseReview;
import com.project.rateMyLearning.model.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchCourseDto {

    private Course course;
    private List<Review> reviews;
    private int totalReviews;
    private int avgRating;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }
}
