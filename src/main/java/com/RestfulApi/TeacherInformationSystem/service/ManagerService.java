package com.RestfulApi.TeacherInformationSystem.service;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;

public interface ManagerService {
    String createManager(ManagerDTO managerDto);
    String updateManager(String id, ManagerDTO managerDto);
    String deleteManager(String id);
    ManagerDTO getManagerById(String id);
    List<ManagerDTO> getAllManagers();
}

