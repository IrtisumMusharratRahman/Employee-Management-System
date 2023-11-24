package com.project.employee.service;

import com.project.employee.entity.MonthlyAttendance;
import com.project.employee.entity.MonthlyAttendance;
import com.project.employee.repository.MonthlyAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonthlyAttendanceService implements BaseService<MonthlyAttendance> {

    private final MonthlyAttendanceRepository monthlyAttendanceRepository;

    @Autowired
    public MonthlyAttendanceService(MonthlyAttendanceRepository monthlyAttendanceRepository) {
        this.monthlyAttendanceRepository = monthlyAttendanceRepository;
    }

    @Override
    public MonthlyAttendance create(MonthlyAttendance entity) {
        return monthlyAttendanceRepository.save(entity);
    }

    @Override
    public MonthlyAttendance update(MonthlyAttendance entity) {
        return monthlyAttendanceRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        monthlyAttendanceRepository.deleteById(id);
    }

    @Override
    public List<MonthlyAttendance> getAll() {
        return monthlyAttendanceRepository.findAll();
    }

    @Override
    public Optional<MonthlyAttendance> getById(UUID id) {
        return monthlyAttendanceRepository.findById(id);
    }
}
