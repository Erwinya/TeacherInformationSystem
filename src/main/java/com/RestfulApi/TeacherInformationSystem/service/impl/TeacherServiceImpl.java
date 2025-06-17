package com.RestfulApi.TeacherInformationSystem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.RestfulApi.TeacherInformationSystem.model.Teacher;
import com.RestfulApi.TeacherInformationSystem.repository.TeacherRepository;
import com.RestfulApi.TeacherInformationSystem.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher); 
    }

    @Override
    public Teacher updateTeacher(String id, Teacher teacher) {
       Teacher existing = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        existing.setName(teacher.getName());
        existing.setSurname(teacher.getSurname());
        existing.setEmail(teacher.getEmail());
        existing.setPhoneNumber(teacher.getPhoneNumber());
        return teacherRepository.save(existing);
    }

    @Override
    public void deleteTeacher(String id) {
       teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getTeacherById(String id) {
         return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

}
