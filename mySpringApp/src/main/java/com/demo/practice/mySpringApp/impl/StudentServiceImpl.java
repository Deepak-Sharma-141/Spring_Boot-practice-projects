package com.demo.practice.mySpringApp.impl;

import com.demo.practice.mySpringApp.dto.StudentDTO;
import com.demo.practice.mySpringApp.entity.Student;
import com.demo.practice.mySpringApp.repository.StudentRepository;
import com.demo.practice.mySpringApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students =studentRepository.findAll();

        return students
                .stream()
                .map(student -> new StudentDTO(student.getId(),student.getName(),student.getEmail()))
                .toList();
    }

    @Override
    public StudentDTO getStudentsById(Long id) {
       Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with ID: "+id));
        return modelMapper.map(student,StudentDTO.class);
    }
}
