package com.RestfulApi.TeacherInformationSystem.mapper;

import com.RestfulApi.TeacherInformationSystem.dto.ManagerDto;
import com.RestfulApi.TeacherInformationSystem.model.Manager;

public class ManagerMapper {
    public static ManagerDto toDto(Manager manager) {
        if (manager == null) {
            return null;
        }
        ManagerDto managerDto = new ManagerDto();
        managerDto.setName(manager.getName());
        managerDto.setSurname(manager.getSurname());
        managerDto.setEmail(manager.getEmail());
        managerDto.setPhoneNumber(manager.getPhoneNumber());
        managerDto.setResponsibility(manager.getResponsibility());
        return managerDto;
    }
    public static Manager totoEntity(ManagerDto managerDto) {
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