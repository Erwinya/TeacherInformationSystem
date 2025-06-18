package com.RestfulApi.TeacherInformationSystem.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class TeacherDto {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String department;
}
