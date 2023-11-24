package com.project.employee.repository;

import com.project.employee.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, UUID> {
}
