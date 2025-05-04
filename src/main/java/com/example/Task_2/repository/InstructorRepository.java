package com.example.Task_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task_2.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    Instructor findInstructorByEmail(String email);

}
