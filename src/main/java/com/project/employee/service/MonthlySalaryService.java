package com.project.employee.service;

import com.project.employee.entity.MonthlySalary;
import com.project.employee.repository.MonthlySalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonthlySalaryService implements BaseService<MonthlySalary>{

    private final MonthlySalaryRepository monthlySalaryRepository;

    @Autowired
    public MonthlySalaryService(MonthlySalaryRepository monthlySalaryRepository) {
        this.monthlySalaryRepository = monthlySalaryRepository;
    }

    @Override
    public MonthlySalary create(MonthlySalary entity) {
        return monthlySalaryRepository.save(entity);
    }

    @Override
    public MonthlySalary update(MonthlySalary entity) {
        return monthlySalaryRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        monthlySalaryRepository.deleteById(id);
    }

    @Override
    public List<MonthlySalary> getAll() {
        return monthlySalaryRepository.findAll();
    }

    @Override
    public Optional<MonthlySalary> getById(UUID id) {
        return monthlySalaryRepository.findById(id);
    }
}
