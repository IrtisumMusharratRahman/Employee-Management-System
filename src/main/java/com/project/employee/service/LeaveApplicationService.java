package com.project.employee.service;

import com.project.employee.entity.LeaveApplication;
import com.project.employee.entity.LeaveApplication;
import com.project.employee.repository.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class LeaveApplicationService implements BaseService<LeaveApplication>{

    private final LeaveApplicationRepository leaveApplicationRepository;

    @Autowired
    public LeaveApplicationService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Override
    public LeaveApplication create(LeaveApplication entity) {
        return leaveApplicationRepository.save(entity);
    }

    @Override
    public LeaveApplication update(LeaveApplication entity) {
        return leaveApplicationRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        leaveApplicationRepository.deleteById(id);
    }

    @Override
    public List<LeaveApplication> getAll() {
        return leaveApplicationRepository.findAll();
    }

    @Override
    public Optional<LeaveApplication> getById(UUID id) {
        return leaveApplicationRepository.findById(id);
    }
}