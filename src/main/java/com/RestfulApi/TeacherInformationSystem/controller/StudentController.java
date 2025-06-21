package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.StudentDTO;
import com.RestfulApi.TeacherInformationSystem.mapper.StudentMapper;
import com.RestfulApi.TeacherInformationSystem.model.Student;
import com.RestfulApi.TeacherInformationSystem.service.StudentService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(StudentMapper.mapToStudentDto(createdStudent));
    }
    
    @GetMapping
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(StudentMapper.mapToStudentDto(student));
    }
    
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOs = studentService.getAllStudents()
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentDTOs);
    }
    
    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(StudentMapper.mapToStudentDto(updatedStudent));
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
