package com.project.employee.controller;

import com.project.employee.entity.MonthlyAttendance;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.MonthlyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/monthly_attendance")
public class MonthlyAttendanceController {

    private final MonthlyAttendanceService monthlyAttendanceService;

    @Autowired
    public MonthlyAttendanceController(MonthlyAttendanceService monthlyAttendanceService) {
        this.monthlyAttendanceService = monthlyAttendanceService;
    }

    @PostMapping
    public MonthlyAttendance create(@RequestBody MonthlyAttendance entity) {
        return monthlyAttendanceService.create(entity);
    }

    @PutMapping
    public MonthlyAttendance update(@RequestBody MonthlyAttendance entity) {
        return monthlyAttendanceService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        monthlyAttendanceService.delete(id);
    }

    @GetMapping
    public List<MonthlyAttendance> getAll() {
        return monthlyAttendanceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MonthlyAttendance> getById(@PathVariable("id") UUID id) {
        return monthlyAttendanceService.getById(id);
    }
}