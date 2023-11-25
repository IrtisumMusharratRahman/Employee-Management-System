package com.project.employee.controller;

import com.project.employee.entity.LeaveApplication;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/leave_application")
public class LeaveApplicationController {

    private final LeaveApplicationService leaveApplicationService;

    @Autowired
    public LeaveApplicationController(LeaveApplicationService leaveApplicationService) {
        this.leaveApplicationService = leaveApplicationService;
    }

    @PostMapping
    public LeaveApplication create(@RequestBody LeaveApplication entity) {
        return leaveApplicationService.create(entity);
    }

    @PutMapping
    public LeaveApplication update(@RequestBody LeaveApplication entity) {
        return leaveApplicationService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        leaveApplicationService.delete(id);
    }

    @GetMapping
    public List<LeaveApplication> getAll() {
        return leaveApplicationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<LeaveApplication> getById(@PathVariable("id") UUID id) {
        return leaveApplicationService.getById(id);
    }
}