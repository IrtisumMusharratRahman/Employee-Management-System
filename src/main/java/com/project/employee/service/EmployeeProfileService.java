package com.project.employee.service;

import com.project.employee.entity.EmployeeProfile;
import com.project.employee.repository.EmployeeProfileRepository;
import com.project.employee.repository.MonthlySalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeProfileService implements BaseService<EmployeeProfile>{

    private final EmployeeProfileRepository employeeProfileRepository;

    @Autowired
    public EmployeeProfileService(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }

    @Override
    public EmployeeProfile create(EmployeeProfile entity) {
        return employeeProfileRepository.save(entity);
    }

    @Override
    public EmployeeProfile update(EmployeeProfile entity) {
        return employeeProfileRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        employeeProfileRepository.deleteById(id);
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return employeeProfileRepository.findAll();
    }

    @Override
    public Optional<EmployeeProfile> getById(UUID id) {
        return employeeProfileRepository.findById(id);
    }
}