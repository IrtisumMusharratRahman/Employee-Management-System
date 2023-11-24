package com.project.employee.service;

import com.project.employee.entity.Department;
import com.project.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DepartmentService implements BaseService<Department>{

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department create(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public Department update(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getById(UUID id) {
        return departmentRepository.findById(id);
    }
}