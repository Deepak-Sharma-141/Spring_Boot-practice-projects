package com.deepak.spring.LearningRestAPIs.service;

import com.deepak.spring.LearningRestAPIs.dto.AddStudentRequestDto;
import com.deepak.spring.LearningRestAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentsById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePatrialStudent(Long id, Map<String, Object> updates);
}
