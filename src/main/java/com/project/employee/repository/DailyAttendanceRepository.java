package com.project.employee.repository;

import com.project.employee.entity.DailyAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DailyAttendanceRepository extends JpaRepository<DailyAttendance, UUID> {
}
