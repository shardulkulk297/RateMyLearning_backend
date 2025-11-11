package com.project.rateMyLearning.repository;

import com.project.rateMyLearning.model.Review;
import com.project.rateMyLearning.model.Reviewer;
import com.project.rateMyLearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {
    @Query("Select r from Reviewer r WHERE r.email = ?1")
    Reviewer getReviewerByEmail(String email);

    List<Reviewer> user(User user);
    @Query("Select u from Reviewer u WHERE u.user.username = ?1")
    Reviewer getByUsername(String username);

    @Query("Select r from Review r WHERE r.reviewer.user.username=?1")
    List<Review> getReviewsByUsername(String name);
<<<<<<< HEAD
=======


    @Query("Select r from Reviewer r WHERE r.ipAddress = ?1")
    int getReviewerIpCount(String clientIp);
>>>>>>> 8136dcb (Added account creation and review posting limit in both addReviewer Method and postReview method so that there is no spoofing of the reviews)
}
