package com.group.hrapplication.service.EmployeeService;

import com.group.hrapplication.domain.employee.Employee;
import com.group.hrapplication.domain.employee.EmployeeRepository;
import com.group.hrapplication.dto.employee.request.EmployeeCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){this.employeeRepository = employeeRepository;}

    @Transactional
    public void saveEmployee(EmployeeCreateRequest request){
        employeeRepository.save(new Employee(
                request.getEmployeeName(), request.getRoleId(),
                request.getWorkStartDate(), request.getBirthday()));
    }

    @Transactional
    public List<Employee> findEmployeeInfo(String employeeName){
        if(Objects.equals(employeeName, "All")){
            return employeeRepository.findAll();
        }else{
            return employeeRepository.findByEmployeeName(employeeName);
        }
    }

    @Transactional
    public Employee findManagerName(Long teamId, Long roleId){
        return employeeRepository.findByTeamIdAndRoleId(teamId, roleId);
    }

    @Transactional
    public Long countTeamEmployee(Long teamId){
        return employeeRepository.countByTeamId(teamId);
    }



}
