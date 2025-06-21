package com.RestfulApi.TeacherInformationSystem.mapper;

import java.util.stream.Collectors;

import com.RestfulApi.TeacherInformationSystem.dto.SchoolClassDTO;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;

public class SchoolClassMapper {
    public static SchoolClassDTO toDto(SchoolClass schoolClass) {
        if (schoolClass == null) {
            return null;
        }
        SchoolClassDTO dto = new SchoolClassDTO();
        dto.setName(schoolClass.getName());
        // dto.setTeacher(TeacherMapper.toDto(schoolClass.getTeacher()));
        // Eğer SchoolClass entity'de getTeacher() yoksa, bu satır kaldırılmalı veya teacherId atanmalı.
        // Eğer teacherId varsa:
        // dto.setTeacherId(schoolClass.getTeacherId());
        if (schoolClass.getStudents() != null) {
            dto.setStudents(schoolClass.getStudents().stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList()));
        }
        return dto;
    }
    public static SchoolClass toEntity(SchoolClassDTO dto) {
        if (dto == null) {
            return null;
        }
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(dto.getName());
        // if (dto.getTeacher() != null) {
        //     schoolClass.setTeacher(TeacherMapper.toEntity(dto.getTeacher()));
        // }
        // Eğer teacherId varsa:
        // schoolClass.setTeacherId(dto.getTeacherId());
        return schoolClass;
    }
}
