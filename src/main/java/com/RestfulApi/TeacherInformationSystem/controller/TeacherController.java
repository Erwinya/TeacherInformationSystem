package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.TeacherDTO;
import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;
import com.RestfulApi.TeacherInformationSystem.service.TeacherService;
import com.RestfulApi.TeacherInformationSystem.mapper.TeacherMapper;
import com.RestfulApi.TeacherInformationSystem.util.ApiResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public CustomResponse<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        var createdTeacher = teacherService.createTeacher(TeacherMapper.toEntity(teacherDTO));
        return ApiResponseUtil.success(TeacherMapper.toDto(createdTeacher));
    }

    @GetMapping("/{id}")
    public CustomResponse<TeacherDTO> getTeacherById(@PathVariable String id) {
        var teacher = teacherService.getTeacherById(id);
        return ApiResponseUtil.success(TeacherMapper.toDto(teacher));
    }

    @GetMapping
    public CustomResponse<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teacherDTOs = teacherService.getAllTeachers()
                .stream()
                .map(TeacherMapper::toDto)
                .collect(Collectors.toList());
        return ApiResponseUtil.success(teacherDTOs);
    }

    @PutMapping("/{id}")
    public CustomResponse<TeacherDTO> updateTeacher(@PathVariable String id, @RequestBody TeacherDTO teacherDTO) {
        var updatedTeacher = teacherService.updateTeacher(id, TeacherMapper.toEntity(teacherDTO));
        return ApiResponseUtil.success(TeacherMapper.toDto(updatedTeacher));
    }

    @DeleteMapping("/{id}")
    public CustomResponse<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ApiResponseUtil.success(null);
    }
}
