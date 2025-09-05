package com.project.rateMyLearning.service;

import com.project.rateMyLearning.dto.SearchCourseDto;
import com.project.rateMyLearning.model.CourseReview;
import com.project.rateMyLearning.repository.CourseReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseReviewService {

    private final CourseReviewRepository courseReviewRepository;

    public CourseReviewService(CourseReviewRepository courseReviewRepository) {
        this.courseReviewRepository = courseReviewRepository;
    }

    public List<SearchCourseDto> searchCourse(String courseName) {
        List<CourseReview> courses = courseReviewRepository.searchCourses(courseName);

        return null;
    }



}
