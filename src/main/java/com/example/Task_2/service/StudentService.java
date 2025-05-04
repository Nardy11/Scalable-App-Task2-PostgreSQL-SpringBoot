package com.example.Task_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task_2.model.Student;
import com.example.Task_2.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving students: " + e.getMessage(), e);
        }
    }

    public Optional<Student> getStudentById(Integer id) {
        try {
            return studentRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving student with ID " + id + ": " + e.getMessage(), e);
        }
    }

    public Student saveStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Error saving student: " + e.getMessage(), e);
        }
    }

    public void deleteStudent(Integer id) {
        try {
            if (!studentRepository.existsById(id)) {
                throw new RuntimeException("Student not found with ID: " + id);
            }
            studentRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error deleting student with ID " + id + ": " + e.getMessage(), e);
        }
    }

    public List<Student> getStudentsByCourseId(Integer courseId) {
        try {
            return studentRepository.findStudentsByCourseId(courseId);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving students for course ID " + courseId + ": " + e.getMessage(), e);
        }
    }

    public Student updateStudent(Integer id, Student student) {
        try {
            return studentRepository.findById(id).map(existingStudent -> {
                existingStudent.setName(student.getName());
                existingStudent.setEmail(student.getEmail());
                return studentRepository.save(existingStudent);
            }).orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error updating student with ID " + id + ": " + e.getMessage(), e);
        }
    }
}
