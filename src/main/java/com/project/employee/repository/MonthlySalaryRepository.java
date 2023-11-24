package com.project.employee.repository;

import com.project.employee.entity.MonthlySalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonthlySalaryRepository extends JpaRepository<MonthlySalary, UUID> {
}
