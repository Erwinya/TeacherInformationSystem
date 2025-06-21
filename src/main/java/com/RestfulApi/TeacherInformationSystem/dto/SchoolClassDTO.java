package com.RestfulApi.TeacherInformationSystem.dto;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClassDTO {
    private String name;
    private Teacher teacher;
    private List<StudentDTO> students;
}
