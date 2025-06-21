package com.RestfulApi.TeacherInformationSystem.service;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;

public interface ManagerService {
    String createManager(ManagerDTO managerDto);
    String updateManager(String id, ManagerDTO managerDto);
    String deleteManager(String id);
    String getManagerById(String id);
    List<String> getAllManagers();
}

