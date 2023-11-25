package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employee_leave")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "leave_id")
    private UUID leaveId;

    @Column(name = "employee_id")
    private UUID employeeId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "remaining_al")
    private Integer remainingAl;

    @Column(name = "remaining_el")
    private Integer remainingEl;

    @Column(name = "remaining_ml")
    private Integer remainingMl;

    @Column(name = "total_leave_balance")
    private Integer totalLeaveBalance;

    @Column(name = "total_unpaid_leave")
    private Integer totalUnpaidLeave;

}
