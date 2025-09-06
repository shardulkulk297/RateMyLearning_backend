package com.project.rateMyLearning.contoller;

import com.project.rateMyLearning.service.CourseReviewService;
import com.project.rateMyLearning.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseReviewController {

    private final CourseService courseService;
    private final CourseReviewService courseReviewService;

    public CourseReviewController(CourseService courseService, CourseReviewService courseReviewService) {
        this.courseService = courseService;
        this.courseReviewService = courseReviewService;
    }

    @GetMapping("/api/course/review/search/{courseName}")
    public ResponseEntity<?> searchCourse(@PathVariable String courseName){
        return ResponseEntity.status(HttpStatus.OK).body(courseReviewService.searchCourse(courseName));
    }




}
