package com.project.rateMyLearning.service;

import com.project.rateMyLearning.model.Course;
import com.project.rateMyLearning.model.CourseReview;
import com.project.rateMyLearning.model.Instructor;
import com.project.rateMyLearning.repository.CourseRepository;
import com.project.rateMyLearning.repository.CourseReviewRepository;
import com.project.rateMyLearning.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CourseService {


    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseReviewRepository courseReviewRepository;

    private Logger logger = Logger.getLogger(CourseService.class.getName());

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
            course.setInstructor(instructor);
            logger.info("New Instructor added successfully, this doesn't exist");
        }
        else{
            course.setInstructor(instructor1);
            logger.info("Instructor already exist");
        }


        Course c = courseRepository.findByCourseTitle(course.getTitle(), course.getLink());
        if(c != null){
            logger.info("Course already exist");
            return c;
        }

        logger.info("Course added successfully, this doesn't exist");
        return courseRepository.save(course);
    }


}
