package com.example.Task_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task_2.model.Instructor;
import com.example.Task_2.repository.InstructorRepository;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        try {
            return instructorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving instructors: " + e.getMessage(), e);
        }
    }

    public Optional<Instructor> getInstructorByID(Integer id) {
        try {
            return instructorRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving instructor with ID " + id + ": " + e.getMessage(), e);
        }
    }

    public Instructor getInstructorByEmail(String email) {
        try {
            return instructorRepository.findInstructorByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving instructor with email " + email + ": " + e.getMessage(), e);
        }
    }
}
