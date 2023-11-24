package com.project.employee.service;

import com.project.employee.entity.DailyAttendance;
import com.project.employee.repository.DailyAttendanceRepository;
import com.project.employee.repository.MonthlySalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DailyAttendanceService implements BaseService<DailyAttendance>{

    private final DailyAttendanceRepository dailyAttendanceRepository;

    @Autowired
    public DailyAttendanceService(DailyAttendanceRepository dailyAttendanceRepository) {
        this.dailyAttendanceRepository = dailyAttendanceRepository;
    }

    @Override
    public DailyAttendance create(DailyAttendance entity) {
        return dailyAttendanceRepository.save(entity);
    }

    @Override
    public DailyAttendance update(DailyAttendance entity) {
        return dailyAttendanceRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        dailyAttendanceRepository.deleteById(id);
    }

    @Override
    public List<DailyAttendance> getAll() {
        return dailyAttendanceRepository.findAll();
    }

    @Override
    public Optional<DailyAttendance> getById(UUID id) {
        return dailyAttendanceRepository.findById(id);
    }
}