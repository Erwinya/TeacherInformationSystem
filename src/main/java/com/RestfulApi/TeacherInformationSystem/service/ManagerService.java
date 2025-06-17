package com.RestfulApi.TeacherInformationSystem.service;

import java.util.List;
import com.RestfulApi.TeacherInformationSystem.model.Manager;

public interface ManagerService {
    Manager createManager(Manager manager);
    Manager updateManager(String id, Manager manager);
    void deleteManager(String id);
    Manager getManagerById(String id);
    List<Manager> getAllManagers();
}

