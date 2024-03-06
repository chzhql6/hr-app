package com.group.hrapplication.controller.employee;

import com.group.hrapplication.domain.employee.Employee;
import com.group.hrapplication.dto.employee.request.EmployeeCreateRequest;
import com.group.hrapplication.dto.employee.request.EmployeeInfoRequest;
import com.group.hrapplication.dto.employee.response.EmployeeInfoResponse;
import com.group.hrapplication.service.EmployeeService.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

    @PostMapping("/employee/create")
    public void saveEmployee(@RequestBody EmployeeCreateRequest request){
        employeeService.saveEmployee(request);
    }

    @PostMapping("/employee/info")
    public List<EmployeeInfoResponse> findEmployeeInfo(@RequestBody EmployeeInfoRequest request){

        ArrayList<EmployeeInfoResponse> list = new ArrayList<>();

        List<Employee> tmp_emp = employeeService.findEmployeeInfo(request.getEmployeeName());
        for(Employee employee : tmp_emp){
            String role;
            if(employee.getRoleId() == 0L){
                role = "MANAGER";
            }else if(employee.getRoleId() != 0L){
                role = "MEMBER";
            }else{
                role = null;
            }

            EmployeeInfoResponse tmp_EIR = new EmployeeInfoResponse(employee.getEmployeeName(),
                    employee.getTeamName(), role, employee.getBirthday(), employee.getWorkStartDate());
            list.add(tmp_EIR);
        }
        return list;
    }

}
