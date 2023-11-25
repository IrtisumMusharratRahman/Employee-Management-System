package com.project.employee.controller;

import com.project.employee.entity.MonthlySalary;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.MonthlySalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/monthly_salary")
public class MonthlySalaryController {

    private final MonthlySalaryService monthlySalaryService;

    @Autowired
    public MonthlySalaryController(MonthlySalaryService monthlySalaryService) {
        this.monthlySalaryService = monthlySalaryService;
    }

    @PostMapping
    public MonthlySalary create(@RequestBody MonthlySalary entity) {
        return monthlySalaryService.create(entity);
    }

    @PutMapping
    public MonthlySalary update(@RequestBody MonthlySalary entity) {
        return monthlySalaryService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        monthlySalaryService.delete(id);
    }

    @GetMapping
    public List<MonthlySalary> getAll() {
        return monthlySalaryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MonthlySalary> getById(@PathVariable("id") UUID id) {
        return monthlySalaryService.getById(id);
    }
}