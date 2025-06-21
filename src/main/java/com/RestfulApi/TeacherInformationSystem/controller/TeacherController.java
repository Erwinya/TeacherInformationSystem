package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.TeacherDTO;
import com.RestfulApi.TeacherInformationSystem.mapper.TeacherMapper;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;
import com.RestfulApi.TeacherInformationSystem.service.TeacherService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    
    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok(TeacherMapper.toDto(createdTeacher));
    }
    
    @GetMapping
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable String id) {
        Teacher teacher = teacherService.getTeacherById(String.valueOf(UUID.fromString(id)));
        return ResponseEntity.ok(TeacherMapper.toDto(teacher));
    }
    
    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teacherDTOs = teacherService.getAllTeachers()
                .stream()
                .map(TeacherMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(teacherDTOs);
    }
    
    @PutMapping
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable String id, @RequestBody TeacherDTO teacherDTO) {
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
