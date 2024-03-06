package com.group.hrapplication.dto.employee.request;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class EmployeeCreateRequest {

    private String employeeName;

    private Long roleId;

    private LocalDate workStartDate;

    private LocalDate birthday;


    public String getEmployeeName() {
        return employeeName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
