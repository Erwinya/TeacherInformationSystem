package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.ManagerDTO;
import com.RestfulApi.TeacherInformationSystem.mapper.ManagerMapper;
import com.RestfulApi.TeacherInformationSystem.model.Manager;
import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;
import com.RestfulApi.TeacherInformationSystem.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable String id) {
        Manager manager = managerService.getManagerById(id);
        return ResponseEntity.ok(ManagerMapper.toDto(manager));
    }
    
    @GetMapping
    public ResponseEntity<List<ManagerDTO>> getAllManagers() {
        List<ManagerDTO> managerDTOs = managerService.getAllManagers()
                .stream()
                .map(ManagerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(managerDTOs);
    }
    
    @PutMapping
    public ResponseEntity<ManagerDTO> updateManager(@PathVariable String id, @RequestBody ManagerDTO managerDTO) {
        Manager manager = ManagerMapper.toEntity(managerDTO);
        Manager updatedManager = managerService.updateManager(id, manager);
        return ResponseEntity.ok(ManagerMapper.toDto(updatedManager));
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteManager(@PathVariable String id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}
