package com.deepak.spring.LearningRestAPIs.service.impl;

import com.deepak.spring.LearningRestAPIs.dto.AddStudentRequestDto;
import com.deepak.spring.LearningRestAPIs.dto.StudentDto;
import com.deepak.spring.LearningRestAPIs.entity.Student;
import com.deepak.spring.LearningRestAPIs.repository.StudentRepository;
import com.deepak.spring.LearningRestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
      List<Student> students =studentRepository.findAll();

        return students
              .stream()
              .map(student -> modelMapper.map(student, StudentDto.class))
              .toList();
    }

    @Override
    public StudentDto getStudentsById(Long id) {
      Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found by ID "+id));
    return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent =modelMapper.map(addStudentRequestDto, Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id:"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePatrialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported: " + field);
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }


}







