package com.RestfulApi.TeacherInformationSystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    Optional<Teacher> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Teacher> findByDepartment(String department);
    List<Teacher> findByNameContainingIgnoreCase(String name);
    List<Teacher> findBySurnameContainingIgnoreCase(String surname);
    List<Teacher> findByNameContainingIgnoreCaseAndSurnameContainingIgnoreCase(String name, String surname);
 }