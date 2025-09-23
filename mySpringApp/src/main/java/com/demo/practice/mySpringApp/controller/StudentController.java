package com.demo.practice.mySpringApp.controller;

import com.demo.practice.mySpringApp.dto.StudentDTO;
import com.demo.practice.mySpringApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/student")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentsById(id);
    }
}
