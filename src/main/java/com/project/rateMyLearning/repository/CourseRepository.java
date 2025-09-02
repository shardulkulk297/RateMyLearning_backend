package com.project.rateMyLearning.repository;

import com.project.rateMyLearning.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("Select c from Course c WHERE c.title = ?1 AND c.link =?2")
    Course findByCourseTitle(String title, String link);
}
