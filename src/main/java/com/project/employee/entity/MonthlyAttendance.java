package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "monthly_attendance")
@Getter
@Setter
@AllArgsConstructor
public class MonthlyAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monthly_attendance_id")
    private UUID monthlyAttendanceId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeProfile employeeProfile;

    @Column(name = "month")
    private LocalDate month;

    @Column(name = "total_working_day")
    private Integer totalWorkingDay;

    @Column(name = "total_attendance")
    private Integer totalAttendance;

    @Column(name = "total_paid_leave")
    private Integer totalPaidLeave;

    @Column(name = "total_unpaid_leave")
    private Integer totalUnpaidLeave;

}
