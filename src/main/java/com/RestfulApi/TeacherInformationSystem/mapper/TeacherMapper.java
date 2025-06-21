package com.RestfulApi.TeacherInformationSystem.mapper;

import com.RestfulApi.TeacherInformationSystem.dto.TeacherDTO;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;

public class TeacherMapper {

    public static TeacherDTO toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherDTO dto = new TeacherDTO();
        dto.setName(teacher.getName());
        dto.setSurname(teacher.getSurname());
        dto.setEmail(teacher.getEmail());
        dto.setPhoneNumber(teacher.getPhoneNumber());
        dto.setDepartment(teacher.getDepartment());
        return dto;
    }
    public static Teacher toEntity(TeacherDTO dto) {
        if (dto == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setSurname(dto.getSurname());
        teacher.setEmail(dto.getEmail());
        teacher.setPhoneNumber(dto.getPhoneNumber());
        teacher.setDepartment(dto.getDepartment());
        return teacher;
    }
}
