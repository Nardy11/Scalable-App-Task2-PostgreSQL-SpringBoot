package com.example.Task_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Task_2.model.Course;

import jakarta.transaction.Transactional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO student_course (student_id, course_id) VALUES (:StudentID, :CourseID)", nativeQuery = true)
    void enrollStudent(@Param("CourseID") Integer CourseID, @Param("StudentID") Integer StudentID);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student_course WHERE student_id = :StudentID AND course_id = :CourseID", nativeQuery = true)
    void unenrollStudent(@Param("CourseID") Integer CourseID, @Param("StudentID") Integer StudentID);

    List<Course> findByInstructorId(Integer instructionId);
}
