package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "monthly_salary")
@Getter
@Setter
@AllArgsConstructor
public class MonthlySalary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monthly_salary_id")
    private UUID monthlySalaryId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeProfile employeeProfile;

    @Column(name = "month")
    private LocalDate month;

    @Column(name = "salary_amount", precision = 10, scale = 2)
    private BigDecimal salaryAmount;

    @Column(name = "bonus", precision = 10, scale = 2)
    private BigDecimal bonus;

    @Column(name = "bonus_remark", columnDefinition = "TEXT")
    private String bonusRemark;

    @Column(name = "deductions", precision = 10, scale = 2)
    private BigDecimal deductions;

    @Column(name = "deduction_remark", columnDefinition = "TEXT")
    private String deductionRemark;

    @Column(name = "pay_date")
    private LocalDate payDate;

}
