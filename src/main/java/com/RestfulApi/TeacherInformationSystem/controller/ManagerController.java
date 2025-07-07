package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;
import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;
import com.RestfulApi.TeacherInformationSystem.service.ManagerService;
import com.RestfulApi.TeacherInformationSystem.util.ApiResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public CustomResponse<String> createManager(@RequestBody ManagerDTO managerDto) {
        String serviceResponse = managerService.createManager(managerDto);
        return ApiResponseUtil.success(serviceResponse);
    }

    @GetMapping("/{id}")
    public CustomResponse<ManagerDTO> getManagerById(@PathVariable String id) {
        ManagerDTO managerDTO = managerService.getManagerById(id);
        return ApiResponseUtil.success(managerDTO);
    }

    @GetMapping
    public CustomResponse<List<ManagerDTO>> getAllManagers() {
        List<ManagerDTO> managerDTOs = managerService.getAllManagers();
        return ApiResponseUtil.success(managerDTOs);
    }

    @PutMapping("/{id}")
    public CustomResponse<ManagerDTO> updateManager(@PathVariable String id, @RequestBody ManagerDTO managerDTO) {
        managerService.updateManager(id, managerDTO);
        ManagerDTO updatedManager = managerService.getManagerById(id);
        return ApiResponseUtil.success(updatedManager);
    }

    @DeleteMapping("/{id}")
    public CustomResponse<Void> deleteManager(@PathVariable String id) {
        managerService.deleteManager(id);
        return ApiResponseUtil.success(null);
    }
}
