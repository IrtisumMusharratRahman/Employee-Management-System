package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "leave_application")
@Getter
@Setter
@AllArgsConstructor
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "application_id")
    private UUID applicationId;

    @ManyToOne
    @JoinColumn(name = "leave_id")
    private EmployeeLeave employeeLeave;

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

    @ManyToOne
    @JoinColumn(name = "approver_id")
    private EmployeeProfile approver;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

}
