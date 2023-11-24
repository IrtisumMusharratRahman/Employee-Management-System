package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "daily_attendance")
@Getter
@Setter
@AllArgsConstructor
public class DailyAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "daily_attendance_id")
    private UUID dailyAttendanceId;

    @ManyToOne
    @JoinColumn(name = "monthly_attendance_id")
    private MonthlyAttendance monthlyAttendance;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "date")
    private LocalDate date;

}
