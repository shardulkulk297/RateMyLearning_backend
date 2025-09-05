package com.project.rateMyLearning.dto;

import com.project.rateMyLearning.model.CourseReview;
import org.springframework.stereotype.Component;

@Component
public class SearchCourseDto {

    private CourseReview courseReview;
    private int totalReviews;
    private int avgRating;

    public CourseReview getCourseReview() {
        return courseReview;
    }

    public void setCourseReview(CourseReview courseReview) {
        this.courseReview = courseReview;
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
