package com.project.employee.controller;

import com.project.employee.entity.DailyAttendance;
import com.project.employee.service.DailyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/daily_attendance")
public class DailyAttendanceController {

    private final DailyAttendanceService dailyAttendanceService;

    @Autowired
    public DailyAttendanceController(DailyAttendanceService dailyAttendanceService) {
        this.dailyAttendanceService = dailyAttendanceService;
    }

    @PostMapping
    public DailyAttendance create(@RequestBody DailyAttendance entity) {
        return dailyAttendanceService.create(entity);
    }

    @PutMapping
    public DailyAttendance update(@RequestBody DailyAttendance entity) {
        return dailyAttendanceService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        dailyAttendanceService.delete(id);
    }

    @GetMapping
    public List<DailyAttendance> getAll() {
        return dailyAttendanceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DailyAttendance> getById(@PathVariable("id") UUID id) {
        return dailyAttendanceService.getById(id);
    }
}
