package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employee_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "info_id")
    private UUID infoId;

    @Column(name = "employee_id")
    private UUID employeeId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "marital_status", length = 20)
    private String maritalStatus;

    @Column(name = "recent_education_qualification", length = 100)
    private String recentEducationQualification;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    @Column(name = "personal_email", length = 100)
    private String personalEmail;

    @Column(name = "office_email", length = 100)
    private String officeEmail;

}