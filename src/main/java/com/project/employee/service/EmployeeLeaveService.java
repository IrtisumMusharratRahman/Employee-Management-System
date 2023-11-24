package com.project.employee.service;

import com.project.employee.entity.EmployeeLeave;
import com.project.employee.repository.EmployeeLeaveRepository;
import com.project.employee.repository.MonthlySalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeLeaveService implements BaseService<EmployeeLeave>{

    private final EmployeeLeaveRepository employeeLeaveRepository;

    @Autowired
    public EmployeeLeaveService(EmployeeLeaveRepository employeeLeaveRepository) {
        this.employeeLeaveRepository = employeeLeaveRepository;
    }

    @Override
    public EmployeeLeave create(EmployeeLeave entity) {
        return employeeLeaveRepository.save(entity);
    }

    @Override
    public EmployeeLeave update(EmployeeLeave entity) {
        return employeeLeaveRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        employeeLeaveRepository.deleteById(id);
    }

    @Override
    public List<EmployeeLeave> getAll() {
        return employeeLeaveRepository.findAll();
    }

    @Override
    public Optional<EmployeeLeave> getById(UUID id) {
        return employeeLeaveRepository.findById(id);
    }
}