package com.RestfulApi.TeacherInformationSystem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.RestfulApi.TeacherInformationSystem.model.SchoolClass;
import com.RestfulApi.TeacherInformationSystem.repository.SchoolClassRepository;
import com.RestfulApi.TeacherInformationSystem.service.SchoolClassService;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    
    public SchoolClassServiceImpl(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }
    
    @Override
    public SchoolClass createClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }
    
    @Override
    public SchoolClass updateClass(String id, SchoolClass schoolClass) {
        SchoolClass existing = schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        existing.setName(schoolClass.getName());
        existing.setTeacherId(schoolClass.getTeacherId());
        existing.setStudents(schoolClass.getStudents());
        return schoolClassRepository.save(existing);
    }
    
    @Override
    public void deleteClass(String id) {
        schoolClassRepository.deleteById(id);
    }
    
    @Override
    public SchoolClass getClassById(String id) {
        return schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
    }

    @Override
    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }
    
    @Override
    public List<SchoolClass> getClassesByTeacherId(String teacherId) {
        List<SchoolClass> classes = schoolClassRepository.findByTeacherId(teacherId);
        if (classes == null || classes.isEmpty()) {
            throw new RuntimeException("No classes found for this teacher");
        }
        return classes;
    }
}