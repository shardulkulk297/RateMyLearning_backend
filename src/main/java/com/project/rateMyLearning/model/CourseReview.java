package com.project.rateMyLearning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_review")
public class CourseReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Review review;
    private int avgRating;
    private int totalReviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }
}
