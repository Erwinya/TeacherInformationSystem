package com.RestfulApi.TeacherInformationSystem.mapper;

import com.RestfulApi.TeacherInformationSystem.model.Student;

public class StudentMapper {
    public static Student mapToStudent(com.RestfulApi.TeacherInformationSystem.dto.StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        Student student = new Student();
        student.setStudentNumber(studentDto.getStudentNumber());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setEnrolledClasses(studentDto.getEnrolledClasses());
        return student;
    }
    public static com.RestfulApi.TeacherInformationSystem.dto.StudentDto mapToStudentDto(Student student) {
        if (student == null) {
            return null;
        }
        com.RestfulApi.TeacherInformationSystem.dto.StudentDto studentDto = new com.RestfulApi.TeacherInformationSystem.dto.StudentDto();
        studentDto.setStudentNumber(student.getStudentNumber());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setEnrolledClasses(student.getEnrolledClasses());
        return studentDto;
    }
}
