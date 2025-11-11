package com.project.rateMyLearning.repository;

import com.project.rateMyLearning.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("Select count(r.id) from Review r WHERE r.reviewer.user.username = ?1")
    int getTotalReviews(String name);
    @Query("Select avg(r.rating) from Review r WHERE r.reviewer.user.username=?1")
    int getAvgRating(String name);
    @Query("Select r from Review r WHERE r.course.link = ?1 AND r.reviewer.user.username = ?2")
    Review getReviewByLink(String link, String username);
    @Query("Select r from Review r WHERE r.course.title LIKE ?1 ORDER BY r.rating DESC")
    List<Review> getReviewsByCourse(String courseTitle);
    @Query("Select count(r) from Review r WHERE r.course.id = ?1")
    int getTotalReviewsForCourse(int courseId);
    @Query("Select avg(r.rating) from Review r WHERE r.course.id=?1")
    int getAvgRatingForCourse(int courseId);
    @Query("Select r from Review r WHERE r.course.id = ?1")
    List<Review> getReviewsForCourse(int id);
<<<<<<< HEAD
=======

    @Query("Select COUNT(r) from Review r WHERE r.course.id = ?1 AND r.ipAddress = ?2")
    int getReviewCountFromIp(int id, String clientIp);
>>>>>>> 8136dcb (Added account creation and review posting limit in both addReviewer Method and postReview method so that there is no spoofing of the reviews)
}
