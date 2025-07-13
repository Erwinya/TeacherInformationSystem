package com.RestfulApi.TeacherInformationSystem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.RestfulApi.TeacherInformationSystem.model.Student;
import com.RestfulApi.TeacherInformationSystem.repository.StudentRepository;
import com.RestfulApi.TeacherInformationSystem.service.StudentService;
import lombok.AllArgsConstructor;
import com.RestfulApi.TeacherInformationSystem.exception.StudentNotFoundException;
import com.RestfulApi.TeacherInformationSystem.exception.DuplicateEmailException;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    
    @Override
    public Student createStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("A student with this email already exists: " + student.getEmail());
        }
        return studentRepository.save(student);
    }
    
    @Override
    public Student updateStudent(String id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        if (!existing.getEmail().equals(student.getEmail()) && studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("A student with this email already exists: " + student.getEmail());
        }
        existing.setStudentNumber(student.getStudentNumber());
        existing.setName(student.getName());
        existing.setSurname(student.getSurname());
        existing.setEmail(student.getEmail());
        existing.setPhoneNumber(student.getPhoneNumber());
        existing.setEnrolledClasses(student.getEnrolledClasses());
        return studentRepository.save(existing);
    }
    
    @Override
    public void deleteStudent(String id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
    
    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                  .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}