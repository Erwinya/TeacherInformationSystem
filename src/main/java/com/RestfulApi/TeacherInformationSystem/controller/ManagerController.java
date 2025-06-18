package com.RestfulApi.TeacherInformationSystem.controller;

import com.RestfulApi.TeacherInformationSystem.dto.ManagerDto;
import com.RestfulApi.TeacherInformationSystem.mapper.ManagerMapper;
import com.RestfulApi.TeacherInformationSystem.model.Manager;
import com.RestfulApi.TeacherInformationSystem.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;
    
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    
    @PostMapping
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto managerDTO) {
        Manager manager = ManagerMapper.totoEntity(managerDTO);
        Manager createdManager = managerService.createManager(manager);
        return ResponseEntity.ok(ManagerMapper.toDto(createdManager));
    }
    
    @GetMapping
    public ResponseEntity<ManagerDto> getManagerById(@PathVariable String id) {
        Manager manager = managerService.getManagerById(id);
        return ResponseEntity.ok(ManagerMapper.toDto(manager));
    }
    
    @GetMapping
    public ResponseEntity<List<ManagerDto>> getAllManagers() {
        List<ManagerDto> managerDTOs = managerService.getAllManagers()
                .stream()
                .map(ManagerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(managerDTOs);
    }
    
    @PutMapping
    public ResponseEntity<ManagerDto> updateManager(@PathVariable String id, @RequestBody ManagerDto managerDTO) {
        Manager manager = ManagerMapper.totoEntity(managerDTO);
        Manager updatedManager = managerService.updateManager(id, manager);
        return ResponseEntity.ok(ManagerMapper.toDto(updatedManager));
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteManager(@PathVariable String id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}
