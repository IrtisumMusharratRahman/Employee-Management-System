package com.project.employee.controller;

import com.project.employee.entity.EmployeeLeave;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.EmployeeLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/employee_leave")
public class EmployeeLeaveController {

    private final EmployeeLeaveService employeeLeaveService;

    @Autowired
    public EmployeeLeaveController(EmployeeLeaveService employeeLeaveService) {
        this.employeeLeaveService = employeeLeaveService;
    }

    @PostMapping
    public EmployeeLeave create(@RequestBody EmployeeLeave entity) {
        return employeeLeaveService.create(entity);
    }

    @PutMapping
    public EmployeeLeave update(@RequestBody EmployeeLeave entity) {
        return employeeLeaveService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        employeeLeaveService.delete(id);
    }

    @GetMapping
    public List<EmployeeLeave> getAll() {
        return employeeLeaveService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeLeave> getById(@PathVariable("id") UUID id) {
        return employeeLeaveService.getById(id);
    }
}