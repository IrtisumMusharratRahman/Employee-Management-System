package com.project.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private UUID departmentId;

    @Column(name = "department_head_id")
    private UUID departmentHeadId;

    @Column(name = "department_name", length = 100)
    private String departmentName;

    @Column(name = "total_members")
    private Integer totalMembers;

}