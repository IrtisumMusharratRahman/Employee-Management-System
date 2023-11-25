package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "monthly_attendance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monthly_attendance_id")
    private UUID monthlyAttendanceId;

    @Column(name = "employee_id")
    private UUID employeeId;

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
