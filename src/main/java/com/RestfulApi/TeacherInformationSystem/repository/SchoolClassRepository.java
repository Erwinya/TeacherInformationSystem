package com.RestfulApi.TeacherInformationSystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, String> {
    List<SchoolClass> findByNameContainingIgnoreCase(String name);
    List<SchoolClass> findByTeacher(Teacher teacher);
    boolean existsByName(String name);
}
