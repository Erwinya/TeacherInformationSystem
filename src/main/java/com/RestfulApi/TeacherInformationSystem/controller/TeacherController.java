package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.TeacherDto;
import com.RestfulApi.TeacherInformationSystem.mapper.TeacherMapper;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;
import com.RestfulApi.TeacherInformationSystem.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok(TeacherMapper.toDto(createdTeacher));
    }
    
    @GetMapping
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable String id) {
        Teacher teacher = teacherService.getTeacherById(String.valueOf(UUID.fromString(id)));
        return ResponseEntity.ok(TeacherMapper.toDto(teacher));
    }
    
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> teacherDTOs = teacherService.getAllTeachers()
                .stream()
                .map(TeacherMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(teacherDTOs);
    }
    
    @PutMapping
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable String id, @RequestBody TeacherDto teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        Teacher updatedTeacher = teacherService.updateTeacher(String.valueOf(UUID.fromString(id)), teacher);
        return ResponseEntity.ok(TeacherMapper.toDto(updatedTeacher));
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
