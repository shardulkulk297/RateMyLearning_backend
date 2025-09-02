package com.project.rateMyLearning.repository;

import com.project.rateMyLearning.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    @Query("Select i from Instructor i WHERE i.name = ?1 AND i.profileUrl=?2")
    Instructor findByInstructorDetails(String name, String profileUrl);
}
