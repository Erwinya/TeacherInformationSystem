package com.RestfulApi.TeacherInformationSystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, String> {

    Optional<SchoolClass> findById(String id);
    List<SchoolClass> findByNameContainingIgnoreCase(String name);
    List<SchoolClass> findByTeacherId(String teacherId);
    boolean existsByName(String name);
    void deleteById(String id);  
}
