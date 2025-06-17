package com.RestfulApi.TeacherInformationSystem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.RestfulApi.TeacherInformationSystem.model.Student;
import com.RestfulApi.TeacherInformationSystem.repository.StudentRepository;
import com.RestfulApi.TeacherInformationSystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    @Override
    public Student updateStudent(String id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setStudentNumber(student.getStudentNumber());       
        existing.setName(student.getName());
        existing.setSurname(student.getSurname());
        existing.setEmail(student.getEmail());
        existing.setPhoneNumber(student.getPhoneNumber());
        return studentRepository.save(existing);
    }
    
    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
    
    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}