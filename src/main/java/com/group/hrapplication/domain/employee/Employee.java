package com.group.hrapplication.domain.employee;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255, name = "employee_name")
    private String employeeName;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "work_start_date")
    private LocalDate workStartDate;
    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "pto")
    private Long pto;

    protected Employee() {};

    public Employee(String employeeName, Long roleId,  LocalDate workStartDate, LocalDate birthday) {
        this.employeeName = employeeName;
        this.teamId = null;
        this.teamName = null;
        this.roleId = roleId;
        this.roleName = null;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
        this.pto = null;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Long getPto() {
        return pto;
    }
}
