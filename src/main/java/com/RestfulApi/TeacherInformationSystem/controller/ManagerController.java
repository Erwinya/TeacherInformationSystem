package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;
import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;
import com.RestfulApi.TeacherInformationSystem.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/managers")
public class ManagerController {

    private final ManagerService managerService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<String> createManager(@RequestBody ManagerDTO managerDto) {
        String serviceResponse = managerService.createManager(managerDto);
        CustomResponse<String> response = new CustomResponse<>();
        response.setData(serviceResponse);
        response.setStatusCode(200);
        response.setStatusMessage("SUCCESS");
        response.setTimestamp(Instant.now().toString());
        return response;
    }
    
    @GetMapping
    public CustomResponse<ManagerDTO> getManagerById(@PathVariable String id) {
        ManagerDTO managerDTO = managerService.getManagerById(id);
        CustomResponse<ManagerDTO> response = new CustomResponse<>();
        response.setData(managerDTO);
        response.setStatusCode(200);
        response.setStatusMessage("SUCCESS");
        response.setTimestamp(Instant.now().toString());
        return response;
    }
    
    @GetMapping
    public CustomResponse<List<ManagerDTO>> getAllManagers() {
        List<ManagerDTO> managerDTOs = managerService.getAllManagers()
                .stream()
                .map(ManagerMapper::toDto)
                .collect(Collectors.toList());
        CustomResponse<List<ManagerDTO>> response = new CustomResponse<>();
        response.setData(managerDTOs);
        response.setStatusCode(200);
        response.setStatusMessage("SUCCESS");
        response.setTimestamp(Instant.now().toString());
        return response;
    }
    
    @PutMapping
    public CustomResponse<ManagerDTO> updateManager(@PathVariable String id, @RequestBody ManagerDTO managerDTO) {
        Manager manager = ManagerMapper.toEntity(managerDTO);
        Manager updatedManager = managerService.updateManager(id, manager);
        CustomResponse<ManagerDTO> response = new CustomResponse<>();
        response.setData(ManagerMapper.toDto(updatedManager));
        response.setStatusCode(200);
        response.setStatusMessage("SUCCESS");
        response.setTimestamp(Instant.now().toString());
        return response;
    }
    
    @DeleteMapping
    public CustomResponse<Void> deleteManager(@PathVariable String id) {
        managerService.deleteManager(id);
        CustomResponse<Void> response = new CustomResponse<>();
        response.setData(null);
        response.setStatusCode(204);
        response.setStatusMessage("SUCCESS");
        response.setTimestamp(Instant.now().toString());
        return response;
    }
}
