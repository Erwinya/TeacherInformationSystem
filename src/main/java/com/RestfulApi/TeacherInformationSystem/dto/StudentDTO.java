package com.RestfulApi.TeacherInformationSystem.dto;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String studentNumber;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private List<SchoolClass> enrolledClasses;
}
