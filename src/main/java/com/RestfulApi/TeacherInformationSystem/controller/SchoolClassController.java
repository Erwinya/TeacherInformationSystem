package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.SchoolClassDTO;
import com.RestfulApi.TeacherInformationSystem.mapper.SchoolClassMapper;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;
import com.RestfulApi.TeacherInformationSystem.service.SchoolClassService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/classes")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @PostMapping
    public ResponseEntity<SchoolClassDTO> createClass(@RequestBody SchoolClassDTO schoolClassDTO) {
        SchoolClass schoolClass = SchoolClassMapper.toEntity(schoolClassDTO);
        SchoolClass createdClass = schoolClassService.createClass(schoolClass);
        return ResponseEntity.ok(SchoolClassMapper.toDto(createdClass));
    }
    
    @GetMapping
    public ResponseEntity<SchoolClassDTO> getClassById(@PathVariable String id) {
        SchoolClass schoolClass = schoolClassService.getClassById(id);
        return ResponseEntity.ok(SchoolClassMapper.toDto(schoolClass));
    }
    
    @GetMapping
    public ResponseEntity<List<SchoolClassDTO>> getAllClasses() {
        List<SchoolClassDTO> classDTOs = schoolClassService.getAllClasses()
                .stream()
                .map(SchoolClassMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(classDTOs);
    }
    
    @PutMapping
    public ResponseEntity<SchoolClassDTO> updateClass(@PathVariable String id, @RequestBody SchoolClassDTO schoolClassDTO) {
        SchoolClass schoolClass = SchoolClassMapper.toEntity(schoolClassDTO);
        SchoolClass updatedClass = schoolClassService.updateClass(id, schoolClass);
        return ResponseEntity.ok(SchoolClassMapper.toDto(updatedClass));
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteClass(@PathVariable String id) {
        schoolClassService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<SchoolClassDTO>> getClassesByTeacherId(@PathVariable String teacherId) {
        List<SchoolClassDTO> classDTOs = schoolClassService.getClassesByTeacherId(teacherId)
                .stream()
                .map(SchoolClassMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(classDTOs);
    }
}
