package com.project.employee.controller;

import com.project.employee.entity.EmployeeInfo;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee_info")
public class EmployeeInfoController {

    private final EmployeeInfoService employeeInfoService;

    @Autowired
    public EmployeeInfoController(EmployeeInfoService employeeInfoService) {
        this.employeeInfoService = employeeInfoService;
    }

    @PostMapping
    public EmployeeInfo create(@RequestBody EmployeeInfo entity) {
        return employeeInfoService.create(entity);
    }

    @PutMapping
    public EmployeeInfo update(@RequestBody EmployeeInfo entity) {
        return employeeInfoService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        employeeInfoService.delete(id);
    }

    @GetMapping
    public List<EmployeeInfo> getAll() {
        return employeeInfoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeInfo> getById(@PathVariable("id") UUID id) {
        return employeeInfoService.getById(id);
    }
}