package com.RestfulApi.TeacherInformationSystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RestfulApi.TeacherInformationSystem.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, String> {

    Optional<Manager> findById(String id);
    Optional<Manager> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Manager> findByNameContainingIgnoreCase(String name);
    List<Manager> findBySurnameContainingIgnoreCase(String surname);
    List<Manager> findByNameContainingIgnoreCaseAndSurnameContainingIgnoreCase(String name, String surname);
    void deleteById(String id);
}
