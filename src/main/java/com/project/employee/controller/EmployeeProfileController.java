package com.project.employee.controller;

import com.project.employee.entity.EmployeeProfile;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/employee_profile")
public class EmployeeProfileController {

    private final EmployeeProfileService employeeProfileService;

    @Autowired
    public EmployeeProfileController(EmployeeProfileService employeeProfileService) {
        this.employeeProfileService = employeeProfileService;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile entity) {
        return employeeProfileService.create(entity);
    }

    @PutMapping
    public EmployeeProfile update(@RequestBody EmployeeProfile entity) {
        return employeeProfileService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        employeeProfileService.delete(id);
    }

    @GetMapping
    public List<EmployeeProfile> getAll() {
        return employeeProfileService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeProfile> getById(@PathVariable("id") UUID id) {
        return employeeProfileService.getById(id);
    }
}