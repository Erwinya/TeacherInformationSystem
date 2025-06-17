package com.RestfulApi.TeacherInformationSystem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.RestfulApi.TeacherInformationSystem.model.Manager;
import com.RestfulApi.TeacherInformationSystem.repository.ManagerRepository;
import com.RestfulApi.TeacherInformationSystem.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
    
    @Override
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }
    
    @Override
    public Manager updateManager(String id, Manager manager) {
        Manager existing = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        existing.setName(manager.getName());
        existing.setSurname(manager.getSurname());
        existing.setEmail(manager.getEmail());
        existing.setPhoneNumber(manager.getPhoneNumber());
        existing.setResponsibility(manager.getResponsibility());
        return managerRepository.save(existing);
    }

    @Override
    public void deleteManager(String id) {
        managerRepository.deleteById(id);
    }
    
    @Override
    public Manager getManagerById(String id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
    }
    
    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }
}