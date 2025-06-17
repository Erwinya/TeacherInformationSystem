package com.RestfulApi.TeacherInformationSystem.service;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(String id, Student student);
    void deleteStudent(String id);
    Student getStudentById(String id);
    List<Student> getAllStudents();
}