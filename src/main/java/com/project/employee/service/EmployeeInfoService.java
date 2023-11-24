package com.project.employee.service;

import com.project.employee.entity.EmployeeInfo;
import com.project.employee.repository.EmployeeInfoRepository;
import com.project.employee.repository.MonthlySalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeInfoService implements BaseService<EmployeeInfo>{

    private final EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    public EmployeeInfoService(EmployeeInfoRepository employeeInfoRepository) {
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public EmployeeInfo create(EmployeeInfo entity) {
        return employeeInfoRepository.save(entity);
    }

    @Override
    public EmployeeInfo update(EmployeeInfo entity) {
        return employeeInfoRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        employeeInfoRepository.deleteById(id);
    }

    @Override
    public List<EmployeeInfo> getAll() {
        return employeeInfoRepository.findAll();
    }

    @Override
    public Optional<EmployeeInfo> getById(UUID id) {
        return employeeInfoRepository.findById(id);
    }
}