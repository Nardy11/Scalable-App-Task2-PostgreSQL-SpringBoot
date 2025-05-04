package com.example.Task_2.controller;

import com.example.Task_2.model.Instructor;
import com.example.Task_2.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{email}")
    public Instructor getInstructorByEmail(@PathVariable String email) {
        return instructorService.getInstructorByEmail(email);
    }
}
