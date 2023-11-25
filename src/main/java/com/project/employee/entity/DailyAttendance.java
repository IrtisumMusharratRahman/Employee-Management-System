package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "daily_attendance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "daily_attendance_id")
    private UUID dailyAttendanceId;

    @Column(name = "monthly_attendance_id")
    private UUID monthlyAttendanceId;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "date")
    private LocalDate date;

}
