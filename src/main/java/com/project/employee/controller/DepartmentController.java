package com.project.employee.controller;

import com.project.employee.entity.Department;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department create(@RequestBody Department entity) {
        return departmentService.create(entity);
    }

    @PutMapping
    public Department update(@RequestBody Department entity) {
        return departmentService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        departmentService.delete(id);
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> getById(@PathVariable("id") UUID id) {
        return departmentService.getById(id);
    }
}