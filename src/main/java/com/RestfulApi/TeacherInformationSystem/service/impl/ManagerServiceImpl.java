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
import com.RestfulApi.TeacherInformationSystem.exception.ManagerNotFoundException;
import com.RestfulApi.TeacherInformationSystem.exception.DuplicateEmailException;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    
    @Override
    public String createManager(ManagerDTO managerDTO) {
        if (managerDTO == null) {
            throw new IllegalArgumentException("ManagerDTO null olamaz");
        }
        if (managerRepository.existsByEmail(managerDTO.getEmail())) {
            throw new DuplicateEmailException("Bu email ile zaten bir yönetici mevcut!");
        }
        Manager manager = ManagerMapper.toEntity(managerDTO);
        managerRepository.save(manager);
        return manager.getId();
    }
    
    @Override
    public String updateManager(String id, ManagerDTO managerDTO) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException("Manager bulunamadı: " + id));
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
            throw new IllegalArgumentException("Manager ID boş olamaz");
        }
        managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException("Manager bulunamadı: " + id));
        managerRepository.deleteById(id);
        return id;
    }
    
    @Override
    public ManagerDTO getManagerById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Manager ID boş olamaz");
        }
        Optional<Manager> manager = managerRepository.findById(id);
        return manager.map(ManagerMapper::toDto)
                      .orElseThrow(() -> new ManagerNotFoundException("Manager bulunamadı: " + id));
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        return managerRepository.findAll().stream()
                .map(ManagerMapper::toDto)
                .toList();
    }
}