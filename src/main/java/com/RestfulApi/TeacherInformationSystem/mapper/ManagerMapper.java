package com.RestfulApi.TeacherInformationSystem.mapper;

import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;
import com.RestfulApi.TeacherInformationSystem.model.Manager;

public class ManagerMapper {
    public static ManagerDTO toDto(Manager manager) {
        if (manager == null) {
            return null;
        }
        return new ManagerDTO(
        manager.getName(),
        manager.getSurname(),
        manager.getEmail(),
        manager.getPhoneNumber(),
        manager.getResponsibility());
       
        
    }
    public static Manager toEntity(ManagerDTO managerDto) {
        if (managerDto == null) {
            return null;
        }
        Manager manager = new Manager();
        manager.setName(managerDto.getName());
        manager.setSurname(managerDto.getSurname());
        manager.setEmail(managerDto.getEmail());
        manager.setPhoneNumber(managerDto.getPhoneNumber());
        manager.setResponsibility(managerDto.getResponsibility());
        return manager;
    }
}