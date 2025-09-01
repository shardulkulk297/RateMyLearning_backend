package com.project.rateMyLearning.repository;

import com.project.rateMyLearning.model.Course;
import com.project.rateMyLearning.model.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseReviewRepository extends JpaRepository<CourseReview,Integer> {
    List<CourseReview> course(Course course);
    @Query("Select c from CourseReview c WHERE c.course.title LIKE ?1 ORDER BY c.review.rating desc")
    List<CourseReview> searchCourses(String courseName);
}
