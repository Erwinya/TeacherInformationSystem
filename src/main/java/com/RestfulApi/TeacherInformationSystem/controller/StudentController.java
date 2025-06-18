package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.StudentDto;
import com.RestfulApi.TeacherInformationSystem.mapper.StudentMapper;
import com.RestfulApi.TeacherInformationSystem.model.Student;
import com.RestfulApi.TeacherInformationSystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(StudentMapper.mapToStudentDto(createdStudent));
    }
    
    @GetMapping
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(StudentMapper.mapToStudentDto(student));
    }
    
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDTOs = studentService.getAllStudents()
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentDTOs);
    }
    
    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id, @RequestBody StudentDto studentDTO) {
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
