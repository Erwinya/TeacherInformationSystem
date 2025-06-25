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
            throw new RuntimeException("Manager cannot be null");
            
        }
        managerRepository.save(manager);
        return "Manager created successfully with ID: " + manager.getId();
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
        return "Manager updated successfully with ID: " + manager.getId();
    }

    @Override
    public String deleteManager(String id) {
        if (id.isBlank()) {
            throw new RuntimeException("Manager ID cannot be empty");
        }
        managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        managerRepository.deleteById(id);
        return "Manager deleted successfully with ID: " + id;
    }
    
    @Override
    public ManagerDTO getManagerById(String id) {
        if (id.isBlank()) {
            throw new RuntimeException("Manager ID cannot be empty");
        }
        Optional<Manager> manager = managerRepository.findById(id);
        if(manager.isEmpty()) {
            throw new IllegalArgumentException("Manager ID cannot be blank");
        }
        return ManagerMapper.toDto(manager.get());
    }
    
    @Override
    public List<ManagerDTO> getAllManagers() {
        if (managerRepository.findAll().isEmpty()) {
            throw new RuntimeException("Manager list cannot be empty");
        }
        return managerRepository.findAll()
                .stream()
                .map(ManagerMapper::toDto)
                .toList();
    }
}