package com.RestfulApi.TeacherInformationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String responsibility;
}
