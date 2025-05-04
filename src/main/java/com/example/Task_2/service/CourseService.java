package com.example.Task_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task_2.model.Course;
import com.example.Task_2.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving courses: " + e.getMessage(), e);
        }
    }

    public Optional<Course> getCourseByID(Integer id) {
        try {
            return courseRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving course with ID " + id + ": " + e.getMessage(), e);
        }
    }

    public List<Course> getCoursesByInstructorId(Integer instructorId) {
        try {
            return courseRepository.findByInstructorId(instructorId);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving courses for instructor ID " + instructorId + ": " + e.getMessage(), e);
        }
    }

    public void enrollStudent(Integer courseId, Integer studentId) {
        try {
            courseRepository.enrollStudent(courseId, studentId);
        } catch (Exception e) {
            throw new RuntimeException("Error enrolling student with ID " + studentId + " in course ID " + courseId + ": " + e.getMessage(), e);
        }
    }

    public void unenrollStudent(Integer courseId, Integer studentId) {
        try {
            courseRepository.unenrollStudent(courseId, studentId);
        } catch (Exception e) {
            throw new RuntimeException("Error unenrolling student with ID " + studentId + " from course ID " + courseId + ": " + e.getMessage(), e);
        }
    }
}
