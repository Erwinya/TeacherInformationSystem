package com.RestfulApi.TeacherInformationSystem.dto;

import java.util.List;
import java.util.UUID;

import com.RestfulApi.TeacherInformationSystem.model.Teacher;
import lombok.Data;

@Data
public class SchoolClassDto {
    private UUID id;
    private String name;
    private Teacher teacher;
    private List<StudentDto> students;
}
