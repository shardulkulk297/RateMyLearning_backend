package com.project.rateMyLearning.service;

import com.project.rateMyLearning.model.Course;
import com.project.rateMyLearning.model.CourseReview;
import com.project.rateMyLearning.model.Instructor;
import com.project.rateMyLearning.repository.CourseRepository;
import com.project.rateMyLearning.repository.CourseReviewRepository;
import com.project.rateMyLearning.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseReviewRepository courseReviewRepository;

    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository, CourseReviewRepository courseReviewRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.courseReviewRepository = courseReviewRepository;
    }

    public Course addCourse(Course course) {
        Instructor instructor = course.getInstructor();
        Instructor instructor1 = instructorRepository.findByInstructorDetails(instructor.getName(), instructor.getProfileUrl());
        if(instructor1 ==null){
            instructor = instructorRepository.save(instructor);
        }

        course.setInstructor(instructor1);
        Course c = courseRepository.findByCourseTitle(course.getTitle(), course.getLink());
        if(c != null){
            return c;
        }
        return courseRepository.save(course);
    }


}
