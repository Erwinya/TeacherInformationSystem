package com.RestfulApi.TeacherInformationSystem.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;
import com.RestfulApi.TeacherInformationSystem.mapper.ManagerMapper;
import com.RestfulApi.TeacherInformationSystem.model.Manager;
import com.RestfulApi.TeacherInformationSystem.repository.ManagerRepository;
import com.RestfulApi.TeacherInformationSystem.service.ManagerService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    
    @Override
    public String createManager(ManagerDTO managerDTO) {
        Manager manager = ManagerMapper.toEntity(managerDTO);
        if (manager == null) {
            throw new IllegalArgumentException("Manager cannot be null");
        }
        managerRepository.save(manager);
        return manager.getId();
    }
    
    @Override
    public String updateManager(String id, ManagerDTO managerDTO) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        manager.setName(managerDTO.getName());
        manager.setSurname(managerDTO.getSurname());
        manager.setEmail(managerDTO.getEmail());
        manager.setPhoneNumber(managerDTO.getPhoneNumber());
        manager.setResponsibility(managerDTO.getResponsibility());
        managerRepository.save(manager);
        return manager.getId();
    }

    @Override
    public String deleteManager(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Manager ID cannot be empty");
        }
        managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        managerRepository.deleteById(id);
        return id;
    }
    
    @Override
    public ManagerDTO getManagerById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Manager ID cannot be empty");
        }
        Optional<Manager> manager = managerRepository.findById(id);
        return manager.map(ManagerMapper::toDto)
                      .orElseThrow(() -> new RuntimeException("Manager not found"));
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        return managerRepository.findAll().stream()
                .map(ManagerMapper::toDto)
                .toList();
    }
}