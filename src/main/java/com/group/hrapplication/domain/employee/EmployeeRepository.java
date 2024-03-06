package com.group.hrapplication.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByTeamIdAndRoleId(Long teamId, Long roleId);

    Long countByTeamId(Long teamId);

    List<Employee> findByEmployeeName(String employeeName);
}
