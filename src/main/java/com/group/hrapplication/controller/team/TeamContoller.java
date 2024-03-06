package com.group.hrapplication.controller.team;

import com.group.hrapplication.domain.employee.Employee;
import com.group.hrapplication.domain.team.Team;
import com.group.hrapplication.dto.team.request.TeamCreateRequest;
import com.group.hrapplication.dto.team.request.TeamInfoRequest;
import com.group.hrapplication.dto.team.response.TeamInfoResponse;
import com.group.hrapplication.service.EmployeeService.EmployeeService;
import com.group.hrapplication.service.team.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamContoller {

    private final TeamService teamService;

    private final EmployeeService employeeService;

    public TeamContoller(TeamService teamService, EmployeeService employeeService) {
        this.teamService = teamService;
        this.employeeService = employeeService;}


    @PostMapping("/team/create")
    public void createTem(@RequestBody TeamCreateRequest request){
        teamService.saveTeam(request);
    }

    @PostMapping("/team/info")
    public List<TeamInfoResponse> findTeamInfo(@RequestBody TeamInfoRequest request){

        ArrayList<TeamInfoResponse> list = new ArrayList<>();

        List<Team> temp = teamService.findTeamInfo(request);
        for(Team team : temp){
            Employee tmp_emp = employeeService.findManagerName(team.getId(), 0L);
            String tmp_managerName = null;

            if(tmp_emp != null){
                tmp_managerName = tmp_emp.getEmployeeName();
            }

            TeamInfoResponse tmp_TIR = new TeamInfoResponse(team.getTeamName(), tmp_managerName
                    , employeeService.countTeamEmployee(team.getId()));
            list.add(tmp_TIR);
        }

        return list;
    }



}
