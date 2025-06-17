package com.RestfulApi.TeacherInformationSystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RestfulApi.TeacherInformationSystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findById(String id);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByStudentNumber(String studentNumber);
    boolean existsByEmail(String email);
    boolean existsByStudentNumber(String studentNumber);
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findBySurnameContainingIgnoreCase(String surname);
    List<Student> findByNameContainingIgnoreCaseAndSurnameContainingIgnoreCase(String name, String surname);
    void deleteById(String id);
}
