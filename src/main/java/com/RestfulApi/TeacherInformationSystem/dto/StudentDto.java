package com.RestfulApi.TeacherInformationSystem.dto;

import java.util.List;
import java.util.UUID;

import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;

import lombok.Data;

@Data
public class StudentDto {
    private UUID id;
    private String studentNumber;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private List<SchoolClass> enrolledClasses;
}
