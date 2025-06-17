package com.RestfulApi.TeacherInformationSystem.service;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;

public interface SchoolClassService {
    SchoolClass createClass(SchoolClass schoolClass);
    SchoolClass updateClass(String id, SchoolClass schoolClass);
    void deleteClass(String id);
    SchoolClass getClassById(String id);
    List<SchoolClass> getAllClasses();
    List<SchoolClass> getClassesByTeacherId(String teacherId);
}
