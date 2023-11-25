package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "leave_application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "application_id")
    private UUID applicationId;

    @Column(name = "leave_id")
    private UUID leaveId;

    @Column(name = "leave_type", length = 50)
    private String leaveType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "approver_id")
    private EmployeeProfile approverId;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

}
