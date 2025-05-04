package com.example.Task_2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Task_2.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId")
    ArrayList<Student> findStudentsByCourseId(@Param("courseId") Integer courseId);

}
