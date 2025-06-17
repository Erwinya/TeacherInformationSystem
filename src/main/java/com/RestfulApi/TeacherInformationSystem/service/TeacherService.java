package com.RestfulApi.TeacherInformationSystem.service;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(String id, Teacher teacher);
    void deleteTeacher(String id);
    Teacher getTeacherById(String id);
    List<Teacher> getAllTeachers();
    List<Teacher> getTeachersBySchoolClassId(String schoolClassId);
}
