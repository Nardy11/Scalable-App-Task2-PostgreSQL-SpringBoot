package com.example.Task_2.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;

    private Integer credit;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) 
    @JsonBackReference
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore 
    private List<Student> students = new ArrayList<>();

    public Course(String name, String code, Integer credit, Instructor instructor) {
        this.name = name;
        this.code = code;
        this.credit = credit;
        this.instructor = instructor;
        this.students = new ArrayList<Student>();
    }

}
