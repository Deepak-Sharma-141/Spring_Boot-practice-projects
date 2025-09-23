package com.demo.practice.mySpringApp.service;

import com.demo.practice.mySpringApp.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentsById(Long id);
}
