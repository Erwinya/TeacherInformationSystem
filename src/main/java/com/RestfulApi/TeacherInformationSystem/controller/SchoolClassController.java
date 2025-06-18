package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.SchoolClassDto;
import com.RestfulApi.TeacherInformationSystem.mapper.SchoolClassMapper;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;
import com.RestfulApi.TeacherInformationSystem.service.SchoolClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;
    
    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }
    
    @PostMapping
    public ResponseEntity<SchoolClassDto> createClass(@RequestBody SchoolClassDto schoolClassDTO) {
        SchoolClass schoolClass = SchoolClassMapper.toEntity(schoolClassDTO);
        SchoolClass createdClass = schoolClassService.createClass(schoolClass);
        return ResponseEntity.ok(SchoolClassMapper.toDto(createdClass));
    }
    
    @GetMapping
    public ResponseEntity<SchoolClassDto> getClassById(@PathVariable String id) {
        SchoolClass schoolClass = schoolClassService.getClassById(id);
        return ResponseEntity.ok(SchoolClassMapper.toDto(schoolClass));
    }
    
    @GetMapping
    public ResponseEntity<List<SchoolClassDto>> getAllClasses() {
        List<SchoolClassDto> classDTOs = schoolClassService.getAllClasses()
                .stream()
                .map(SchoolClassMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(classDTOs);
    }
    
    @PutMapping
    public ResponseEntity<SchoolClassDto> updateClass(@PathVariable String id, @RequestBody SchoolClassDto schoolClassDTO) {
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
    public ResponseEntity<List<SchoolClassDto>> getClassesByTeacherId(@PathVariable String teacherId) {
        List<SchoolClassDto> classDTOs = schoolClassService.getClassesByTeacherId(teacherId)
                .stream()
                .map(SchoolClassMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(classDTOs);
    }
}
