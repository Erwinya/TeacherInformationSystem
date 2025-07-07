package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.StudentDTO;
import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;
import com.RestfulApi.TeacherInformationSystem.service.StudentService;
import com.RestfulApi.TeacherInformationSystem.mapper.StudentMapper;
import com.RestfulApi.TeacherInformationSystem.util.ApiResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public CustomResponse<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        var createdStudent = studentService.createStudent(StudentMapper.mapToStudent(studentDTO));
        return ApiResponseUtil.success(StudentMapper.mapToStudentDto(createdStudent));
    }

    @GetMapping("/{id}")
    public CustomResponse<StudentDTO> getStudentById(@PathVariable String id) {
        var student = studentService.getStudentById(id);
        return ApiResponseUtil.success(StudentMapper.mapToStudentDto(student));
    }

    @GetMapping
    public CustomResponse<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOs = studentService.getAllStudents()
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
        return ApiResponseUtil.success(studentDTOs);
    }

    @PutMapping("/{id}")
    public CustomResponse<StudentDTO> updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        var updatedStudent = studentService.updateStudent(id, StudentMapper.mapToStudent(studentDTO));
        return ApiResponseUtil.success(StudentMapper.mapToStudentDto(updatedStudent));
    }

    @DeleteMapping("/{id}")
    public CustomResponse<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ApiResponseUtil.success(null);
    }
}
